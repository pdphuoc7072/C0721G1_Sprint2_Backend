package com.codegym.controller;

import com.codegym.dto.MovieStatsDTO;
import com.codegym.dto.UserStatsDTO;
import com.codegym.service.IMovieService;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatisticsController {
    @Autowired
    private IMovieService iMovieService;
    @Autowired
    public IUserService iUserService;

    //lấy list movie stats
    @GetMapping("movie/stats")
    public ResponseEntity<List<MovieStatsDTO>> getMovieStats() {
        List<MovieStatsDTO> movieStatsList = iMovieService.getMovieStats();
        if (!movieStatsList.isEmpty()) {
            return new ResponseEntity<>(movieStatsList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
//    lấy list user stats
    @GetMapping("user/stats")
    public ResponseEntity<List<UserStatsDTO>> getUserStats() {
        List<UserStatsDTO> userStatsList= iUserService.getUserStatsList();
        if (!userStatsList.isEmpty()) {
            return new ResponseEntity<>(userStatsList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
