package com.codegym.controller;


import com.codegym.model.Movie;
import com.codegym.service.ICategoryService;
import com.codegym.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Optional;

@RestController
@EnableWebMvc
@RequestMapping("api/public")
@CrossOrigin
public class MovieController {
    @Autowired
    private IMovieService iMovieService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("movies/onshowing")
    public ResponseEntity<Page<Movie>> findOnShowingAndSearchMovies(@RequestParam String name,
                                                                    @RequestParam String categoryId,
                                                                    @RequestParam int page,
                                                                    @RequestParam int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Movie> moviePage = iMovieService.findOnShowingAndSearchMovies(name, categoryId, pageable);
        if (moviePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(moviePage, HttpStatus.OK);
    }

    @GetMapping("movies/upcoming")
    public ResponseEntity<Page<Movie>> findUpComingMovies(@RequestParam int page,
                                                         @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Movie> moviePage = iMovieService.findUpComingMovies(pageable);
        if (moviePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(moviePage, HttpStatus.OK);
    }
}
