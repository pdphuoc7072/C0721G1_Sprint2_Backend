package com.codegym.controller;

import com.codegym.model.BookedTicket;
import com.codegym.service.IBookedTicketService;
import com.codegym.service.IUserService;
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
    @Autowired
    IUserService userService;

    @GetMapping("/listticket")
    public ResponseEntity<Page<BookedTicket>> findAllTicketUser(@RequestParam String id,
                                                              @RequestParam int page){
        if(id == null || id == ""){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else if(!userService.existsById(Integer.parseInt(id))){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = PageRequest.of(page, 1);
        Page<BookedTicket> bookedTicketPage = bookedTicketService.findTicketsUser(id, pageable);
        if(bookedTicketPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bookedTicketPage, HttpStatus.OK);
    }
}
