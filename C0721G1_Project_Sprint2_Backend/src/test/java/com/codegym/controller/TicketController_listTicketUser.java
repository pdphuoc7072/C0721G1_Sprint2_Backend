package com.codegym.controller;

import com.codegym.model.BookedTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketController_listTicketUser {
    @Autowired
    private TicketController ticketController;

    @Test
    public void findAllTicketUser_1(){
        ResponseEntity<Page<BookedTicket>> responseEntity
                = (ResponseEntity<Page<BookedTicket>>) this.ticketController.findAllTicketUser(null, 0);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void findAllTicketUser_2(){
        ResponseEntity<Page<BookedTicket>> responseEntity
                = (ResponseEntity<Page<BookedTicket>>) this.ticketController.findAllTicketUser("", 0);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void findAllTicketUser_3_5(){
        ResponseEntity<Page<BookedTicket>> responseEntity
                = (ResponseEntity<Page<BookedTicket>>) this.ticketController.findAllTicketUser("4", 3);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void findAllTicketUser_4_6(){
        ResponseEntity<Page<BookedTicket>> responseEntity
                = (ResponseEntity<Page<BookedTicket>>) this.ticketController.findAllTicketUser("1",0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals("VE-0001", responseEntity.getBody().getContent().get(0).getTicketCode());
    }
}
