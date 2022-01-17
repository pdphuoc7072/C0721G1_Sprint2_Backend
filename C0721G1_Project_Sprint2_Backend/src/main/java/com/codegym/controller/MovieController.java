package com.codegym.controller;

import com.codegym.model.Movie;
import com.codegym.service.IMovieService;
import com.codegym.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user/")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class MovieController {
    @Autowired
    private IMovieService iMovieService;

    @Autowired
    private ISeatService iSeatService;

    @GetMapping("movie/list")
    private ResponseEntity<?> getAllListMovie() {
        List<Movie> movieList = iMovieService.findAll();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping("movie/{id}")
    private ResponseEntity<?> getListDayShowByIdMovie(@PathVariable Long id) {
        Optional<Movie> movie = iMovieService.findById(id);
        if (movie.isPresent()) {
            LocalDate startDate = LocalDate.parse(movie.get().getStartDate());
            LocalDate endDate = LocalDate.parse(movie.get().getEndDate());
            List<String> listTotalDate = new ArrayList<>();
            while (!startDate.isAfter(endDate)) {
                listTotalDate.add(String.valueOf(startDate));
                startDate = startDate.plusDays(1);
            }
            return new ResponseEntity<>(listTotalDate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("movie/{id}")
    private ResponseEntity<?> getListHourShowByIdMovie(@PathVariable Long id) {
        Optional<Movie> movie = iMovieService.findById(id);
        if (movie.isPresent()) {
            String[] array = movie.get().getHourShow().split(";");
            List<String> listHourShow = new ArrayList<>();
            for (String string : array) {
                listHourShow.add(string);
            }
            return new ResponseEntity<>(listHourShow, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("seat/list")
    private ResponseEntity<?> getListSeatByStatus() {
        List<String> listSeatByStatus = iSeatService.findSeatByStatus();
        return new ResponseEntity<>(listSeatByStatus, HttpStatus.OK);
    }
}
