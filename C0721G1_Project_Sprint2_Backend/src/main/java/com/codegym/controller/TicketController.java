package com.codegym.controller;

import com.codegym.model.BookedTicket;
import com.codegym.service.IBookedTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/ticket")
@CrossOrigin
public class TicketController {
    @Autowired
    IBookedTicketService bookedTicketService;

    @GetMapping("/listticket")
    public ResponseEntity<Page<BookedTicket>> findAllEmployee(@RequestParam long id,
                                                              @RequestParam int page){
        Pageable pageable = PageRequest.of(page, 1);
        Page<BookedTicket> bookedTicketPage = bookedTicketService.findTicketsUser(id, pageable);
        if(bookedTicketPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bookedTicketPage, HttpStatus.OK);
    }
}
