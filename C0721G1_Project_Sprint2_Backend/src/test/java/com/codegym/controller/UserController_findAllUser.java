package com.codegym.controller;


import com.codegym.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Objects;

@SpringBootTest
@AutoConfigureMockMvc
public class UserController_findAllUser {

    @Autowired
    private UserController userController;

    @Test
    public void findAllUser_5() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("","","", 3,2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void findAllUser_6() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("","","", 0,2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, Objects.requireNonNull(responseEntity.getBody()).getTotalPages());
        Assertions.assertEquals("Huy", responseEntity.getBody().getContent().get(1).getName());
    }
    @Test
    public void findAllUser_6_1() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("","H","", 0,2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals("Hoa", responseEntity.getBody().getContent().get(0).getName());
    }

    @Test
    public void findAllUser_6_2() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("02","","", 0,2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals("Huy", responseEntity.getBody().getContent().get(0).getName());
    }

    @Test
    public void findAllUser_6_3() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("","","0905465856", 0,2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals("Hoa", responseEntity.getBody().getContent().get(0).getName());
    }

    @Test
    public void findAllUser_5_1() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("fnfhre","","", 3,2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void findAllUser_5_2() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("","fndfn","", 3,2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }
}
