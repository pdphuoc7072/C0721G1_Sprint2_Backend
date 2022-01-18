package com.codegym.controller;


import com.codegym.model.Movie;
import com.codegym.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/movie")
@CrossOrigin
public class MovieController {

    @Autowired
    private IMovieService iMovieService;


    @GetMapping("/list")
    public ResponseEntity<?> getMovieList() {
        List<Movie> movieList = iMovieService.getAll();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (iMovieService.existsByIdMovie(id)) {
            iMovieService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


//    @GetMapping("")
//    public ResponseEntity<?> findAllMovie(@RequestParam(name = "name", required = false) String name,
//                                          @PageableDefault() Pageable pageable) {
//        Page<Movie> moviePage = iMovieService.findAllMovie(name, pageable);
//        if (moviePage.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(moviePage, HttpStatus.OK);
//    }


    @GetMapping("")
    public ResponseEntity<?> findAllMovie(@RequestParam String name,
                                          @RequestParam int page ,
                                          @RequestParam int size ) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "name");
        Page<Movie> moviePage = iMovieService.findAllMovie(name, pageable);
        if (moviePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(moviePage, HttpStatus.OK);
    }


}
