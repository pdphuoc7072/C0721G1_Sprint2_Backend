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
public class MoviesRestController_findAllMovies {
    @Autowired
    private MovieController movieController;

    @Test
    public void findAllMovie_5() throws ParseException {
        ResponseEntity<Page<Movie>> responseEntity
                = (ResponseEntity<Page<Movie>>) this.movieController.findOnShowingAndSearchMovies("", "", 0, 2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    public void findAllMovie_6() throws ParseException {
        ResponseEntity<Page<Movie>> responseEntity
                = (ResponseEntity<Page<Movie>>) this.movieController.findOnShowingAndSearchMovies("", "", 0, 2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Lời Hứa Của Cha", responseEntity.getBody().getContent().get(1).getName());
    }

    @Test
    public void findAllMovie_6_1() throws ParseException {
        ResponseEntity<Page<Movie>> responseEntity
                = (ResponseEntity<Page<Movie>>) this.movieController.findOnShowingAndSearchMovies( "Lời", "", 0, 2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals("Lời Hứa Của Cha", responseEntity.getBody().getContent().get(0).getName());
    }

    @Test
    public void findAllMovie_6_2() throws ParseException {
        ResponseEntity<Page<Movie>> responseEntity
                = (ResponseEntity<Page<Movie>>) this.movieController.findOnShowingAndSearchMovies("Lời Hứa Của Cha", "", 0, 2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals("Lời Hứa Của Cha", responseEntity.getBody().getContent().get(0).getName());
    }
//
    @Test
    public void findAllMovie_6_3() throws ParseException {
        ResponseEntity<Page<Movie>> responseEntity
                = (ResponseEntity<Page<Movie>>) this.movieController.findOnShowingAndSearchMovies( "", "4", 0, 2);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals("Lời Hứa Của Cha", responseEntity.getBody().getContent().get(0).getName());
    }
//
    @Test
    public void findAllMovie_5_1() throws ParseException {
        ResponseEntity<Page<Movie>> responseEntity
                = (ResponseEntity<Page<Movie>>) this.movieController.findOnShowingAndSearchMovies("fnfhre",  "", 0, 2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }
//
    @Test
    public void findAllMovie_5_2() throws ParseException {
        ResponseEntity<Page<Movie>> responseEntity
                = (ResponseEntity<Page<Movie>>) this.movieController.findOnShowingAndSearchMovies("", "5", 0, 2);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }
}
