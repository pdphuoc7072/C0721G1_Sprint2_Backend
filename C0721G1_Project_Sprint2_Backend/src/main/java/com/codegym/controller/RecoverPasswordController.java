package com.codegym.controller;


import com.codegym.model.User;
import com.codegym.service.IUserService;
import com.codegym.util.RandomPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static com.codegym.util.RandomPassword.setPassword;

//Recover Password
@RestController
@CrossOrigin
@RequestMapping("api/public")
public class RecoverPasswordController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    public JavaMailSender emailSender;


    @PostMapping("password/{email}")
    public ResponseEntity<?> getPassword(@PathVariable String email) {
        Optional<User> userOptional = iUserService.findByEmail(email);
        if(!userOptional.isPresent()){
            return new ResponseEntity<>("EmailNotFound",HttpStatus.BAD_REQUEST);
        }
        User user = userOptional.get();
        String randomPassword = RandomPassword.getRandomPassword();
        String password = RandomPassword.setPassword(randomPassword);
        user.setPassword(password);
        iUserService.save(user);
        sendMail(randomPassword,user.getEmail(),user.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void sendMail (String password, String email, String name){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("[Cinema CodeGym] Cấp lại mật khẩu");
        message.setText("Xin chào " + name+ ", \n \n \n " +
                "Theo yêu cầu của bạn, Cinema CodeGym Club gửi lại thông tin mật khẩu để đăng nhập \n \n"+
                "Password: " + password + " \n" +
                "Cảm ơn và chúc bạn một ngày tốt lành." );
        this.emailSender.send(message);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }



}
