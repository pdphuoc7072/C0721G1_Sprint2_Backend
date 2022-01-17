package com.codegym.controller;

import com.codegym.dto.IMovieDTO;
import com.codegym.dto.IUserDTO;
import com.codegym.service.IBookedTickService;
import com.codegym.service.IMovieService;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StatisticsController {
    @Autowired
    public IBookedTickService iBookedTickService;

    //lấy list movie
    @GetMapping("movie/stats/{startDate}/{endDate}")
    public ResponseEntity<List<IMovieDTO>> getMovieStats(@PathVariable String startDate,
                                                         @PathVariable String endDate) {
        LocalDate ld = LocalDate.parse(startDate);
        LocalDate ld1 = LocalDate.parse(endDate);
        List<IMovieDTO> movieStatsList = iBookedTickService.getMovieStatsList(ld, ld1);
        if (!movieStatsList.isEmpty()) {
            return new ResponseEntity<>(movieStatsList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    //lấy user
    @GetMapping("user/stats/{startDate}/{endDate}")
    public ResponseEntity<List<IUserDTO>> getUserStats(@PathVariable String startDate,
                                                       @PathVariable String endDate) {
        LocalDate ld = LocalDate.parse(startDate);
        LocalDate ld1 = LocalDate.parse(endDate);
        List<IUserDTO> userStatsList = iBookedTickService.getUserStatsList(ld, ld1);
        if (!userStatsList.isEmpty()) {
            return new ResponseEntity<>(userStatsList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
