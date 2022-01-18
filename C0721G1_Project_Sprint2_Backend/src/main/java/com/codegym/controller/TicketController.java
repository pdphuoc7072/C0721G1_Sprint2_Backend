package com.codegym.controller;

import com.codegym.dto.BookedTicketDto;
import com.codegym.dto.SeatDto;
import com.codegym.dto.TicketDto;
import com.codegym.model.BookedTicket;
import com.codegym.model.Seat;
import com.codegym.model.Ticket;
import com.codegym.service.IBookTicketService;
import com.codegym.service.ISeatService;
import com.codegym.service.ITicketService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.validation.Valid;
import java.awt.print.Book;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("api/user/")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TicketController {

    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    public ITicketService ticketService;
    @Autowired
    public ISeatService seatService;
    @Autowired
    public IBookTicketService bookTicketService;

    @PostMapping("paypal")
    public ResponseEntity<?> paypal(@Valid @RequestBody TicketDto ticketDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        } else {
            Ticket ticket = new Ticket();
            ticketDto.setCode(getCode());
            BeanUtils.copyProperties(ticketDto, ticket);
            this.ticketService.save(ticket);
            List seatList = ticketDto.getSeats();
            for (int i = 0; i < seatList.size(); i++) {
                SeatDto seatDto = new SeatDto();
                BeanUtils.copyProperties(seatList.get(i), seatDto);
                seatDto.setStatus(1);
                seatDto.setTicket(ticket);
                Seat seat = new Seat();
                BeanUtils.copyProperties(seatDto, seat);
                this.seatService.save(seat);
            }
            BookedTicketDto bookedTicketDto = chaneValueBookTicket(ticketDto);
            BookedTicket bookedTicket = new BookedTicket();
            BeanUtils.copyProperties(bookedTicketDto, bookedTicket);
            this.bookTicketService.save(bookedTicket);
            try {
                qrCode(ticketDto);
                sendEmail(ticketDto);
            } catch (WriterException | IOException | MessagingException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("ticket/{id}")
    public ResponseEntity<?> createTicket(@PathVariable Long id) {
        Ticket ticket = this.ticketService.findById(id).get();
        TicketDto ticketDto = new TicketDto();
        BeanUtils.copyProperties(ticket, ticketDto);
        return new ResponseEntity<>(ticketDto, HttpStatus.OK);
    }

    @GetMapping("seat/{id}")
    public ResponseEntity<?> createSear(@PathVariable Long id) {
        Optional<Seat> seat = this.seatService.findById(id);
        return new ResponseEntity<>(seat.get(), HttpStatus.OK);
    }

    private BookedTicketDto chaneValueBookTicket(TicketDto ticketDto) {
        BookedTicketDto bookedTicketDto = new BookedTicketDto();
        bookedTicketDto.setTicketCode(ticketDto.getCode());
        bookedTicketDto.setCodeUser(ticketDto.getUser().getCode());
        bookedTicketDto.setNameUser(ticketDto.getUser().getName());
        List seatList = ticketDto.getSeats();
        String seat = "";
        int sum = 0;
        for (int i = 0; i < seatList.size(); i++) {
            SeatDto seatDto = new SeatDto();
            BeanUtils.copyProperties(seatList.get(i), seatDto);
            seat += seatDto.getName() + " ";
            sum = seatDto.getPrice();
        }
        bookedTicketDto.setSeatBooked(seat);
        bookedTicketDto.setTotalMoney(sum);
        bookedTicketDto.setDayShow(ticketDto.getSchedule().getDayShow().getName());
        bookedTicketDto.setHourShow(ticketDto.getSchedule().getHourShow().getName());
        bookedTicketDto.setDayBooked(String.valueOf(LocalDate.now()));
        return bookedTicketDto;
    }

    private void qrCode(TicketDto ticketDto) throws WriterException, IOException {
        List seatList = ticketDto.getSeats();
        StringBuilder seat = new StringBuilder();
        for (int i = 0; i < seatList.size(); i++) {
            SeatDto seatDto = new SeatDto();
            BeanUtils.copyProperties(seatList.get(i), seatDto);
            seat.append(seatDto.getName()).append(" ");
        }
        String data = ticketDto.getCode() + " " + ticketDto.getUser().getName() + " "
                + ticketDto.getUser().getCode() + " " + ticketDto.getSchedule().getMovie().getName() + " " + seat;
        String path = "src\\main\\resources\\templates\\qr.jpg";
        BitMatrix matrix;
            matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 350, 350);
            MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
        }

    private void sendEmail(TicketDto ticketDto) throws MessagingException {
        // Recipient's email ID needs to be mentioned.
        String to = ticketDto.getUser().getEmail();
//        seat+price
        List seatList = ticketDto.getSeats();
        String seat = "";
        int sum = 0;
        for (int i = 0; i < seatList.size(); i++) {
            SeatDto seatDto = new SeatDto();
            BeanUtils.copyProperties(seatList.get(i), seatDto);
            seat += seatDto.getName() + " ";
            sum += seatDto.getPrice();
        }
        // Sender's email ID needs to be mentioned
        String from = "C0721G1Cinema@gmail.com";
        final String username = "C0721G1Cinema@gmail.com";//change accordingly
        final String password = "C0721G1999";//change accordingly
        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            // Set Subject: header field
            message.setSubject("[C0721G1Cinema-Thông báo] Xác nhận thanh toán thành công - noreply");
            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");
            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText=
                    "<div style=\"color: #031327\">\n" +
                            "    <div style=\"background: url(https://thumbs.dreamstime.com/b/abstract-background-white-film-strip-frame-cinema-festival-poster-flyer-template-your-design-movie-time-139262949.jpg);\n" +
                            "width: 720px ;height: 480px\">\n" +
                            "        <br>\n" +
                            "        <h2 style=\"text-align: center;\">Kính chào quý khách <strong style=\"color: darkblue\">"+ ticketDto.getUser().getName()+ "</strong></h2>\n" +
                            "        <p><strong>Cảm ơn quý khách đã đặt vé xem phim: </strong>" + "<strong style=\"color: darkblue\">" +ticketDto.getSchedule().getMovie().getName().toUpperCase() + "</strong>" +"</p>\n" +
                            "        <p><strong>MÀN HÌNH: </strong>"+ ticketDto.getSchedule().getMovie().getStudio() + "<p>\n" +
                            "        <p><strong>NGÀY CHIẾU: </strong>"+ ticketDto.getSchedule().getDayShow().getName() + "<p>\n" +
                            "        <p><strong>XUẤT CHIẾU: </strong>"+ ticketDto.getSchedule().getHourShow().getName() + "<p>\n" +
                            "        <p><strong>SỐ GHẾ: </strong>"+ seat + "<p>\n" +
                            "        <p><strong>TỔNG TIỀN: </strong>"+ sum + " VND"+ " </p>\n" +
                            "        <p><strong>Cảm ơn quý khách đã đặt vé xem phim tại <span style=\"color: darkblue\">C0721G1-CINEMA</span></strong></p>\n" +
                            "        <p><strong> CHÚC QUÝ KHÁCH MỘT BUỔI XEM PHIM VUI VẺ </strong></p>\n" +
                            "        <p><strong style=\"color: red\">LƯU Ý: KHI ĐI NHỚ ĐEM THEO MÃ QR ĐẾN QUẦY THU NGÂN ĐỂ XÁC NHẬN ĐẶT VÉ.</strong></p>\n" +
                            "    </div>\n" +
                            "    <img src=\"cid:image\">\n" +
                            "</div>";

            messageBodyPart.setContent(htmlText, "text/html;charset=UTF-8");
            // add it
            multipart.addBodyPart(messageBodyPart);
            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource("src\\main\\resources\\templates\\qr.jpg");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);
            // put everything together
            message.setContent(multipart);
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
    }

    private String getCode() {
        String code = "TK-";
        List<Integer> codeList = new ArrayList<>();
        List<Ticket> ticketList = this.ticketService.findAll();
        if (ticketList.isEmpty()) {
            return ("TK-0001");
        } else {
            for (Ticket ticket : ticketList) {
                String[] arrayCode = ticket.getCode().split("-");
                codeList.add(Integer.parseInt(arrayCode[1]));
            }
            Collections.sort(codeList);
            int index = 0;
            for (int i = 0; i < codeList.size(); i++) {
                if (i == codeList.size() - 1) {
                    index = codeList.size();
                    break;
                }
                if (codeList.get(i + 1) - codeList.get(i) >= 2) {
                    index = i + 1;
                    break;
                }
            }
            if (index > 998) {
                code += (index + 1);
            } else if (index > 98) {
                code += "0" + (index + 1);
            } else if (index > 8) {
                code += "00" + (index + 1);
            } else if (index > 0) {
                code += "000" + (index + 1);
            }
            return (code);
        }
    }
}
