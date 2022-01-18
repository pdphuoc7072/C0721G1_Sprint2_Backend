package com.codegym.controller;


import com.codegym.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieController_findAllMovie {

    @Autowired
    private MovieController movieController;

    @Test
    public void findAllEmployee_5(){
        ResponseEntity<Page<Movie>> responseEntity
                = (ResponseEntity<Page<Movie>>) this.movieController.findAllMovie("",3,2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void findAllEmployee_5_1(){
        ResponseEntity<Page<Movie>> responseEntity
                = (ResponseEntity<Page<Movie>>) this.movieController.findAllMovie("fdsfs", 3,2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }


    @Test
    public void findAllEmployee_6(){
        ResponseEntity<Page<Movie>> responseEntity
                = (ResponseEntity<Page<Movie>>) this.movieController.findAllMovie("", 0,2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals("nguoi nhen", responseEntity.getBody().getContent().get(0).getName());
    }

    @Test
    public void findAllEmployee_6_1(){
        ResponseEntity<Page<Movie>> responseEntity
                = (ResponseEntity<Page<Movie>>) this.movieController.findAllMovie("nguoi nhen", 0,2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals("nguoi nhen", responseEntity.getBody().getContent().get(0).getName());

    }

}
