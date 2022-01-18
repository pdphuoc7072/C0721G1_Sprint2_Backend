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


    //    idType = null
    @Test
    public void findAllUser_7() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser(null, null, null, 3, 2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }


    //    idType = rong
    @Test
    public void findAllUser_8() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("", "", "", 3, 2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }


    //        idType khong ton tai trong DB
    @Test
    public void findAllUser_9_1() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("", "H", "", 3, 2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void findAllUser_9_2() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("02", "", "", 3, 2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void findAllUser_9_3() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("", "", "0905465856", 3, 2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }


    @Test
    public void findAllUser_9_4() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("02", "H", "0905465856", 3, 2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }


    //        idType ton tai trong DB
//            case tra ve list co size > 0

    @Test
    public void findAllUser_11_1() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("NV-001", "", "", 0, 2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals("Nguyễn Văn Nam", responseEntity.getBody().getContent().get(0).getName());
    }


    @Test
    public void findAllUser_11_2() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("", "Nguyễn Văn Nam", "", 0, 2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals("NV-001", responseEntity.getBody().getContent().get(0).getCode());
    }

    @Test
    public void findAllUser_11_3() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("", "", "0905545434", 0, 2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals("Nguyễn Văn Nam", responseEntity.getBody().getContent().get(0).getName());
    }

    @Test
    public void findAllUser_11_4() throws ParseException {
        ResponseEntity<Page<User>> responseEntity
                = (ResponseEntity<Page<User>>) this.userController.findAllUser("NV-001", "Nguyễn Văn Nam", "0905545434", 0, 2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());

    }
}
