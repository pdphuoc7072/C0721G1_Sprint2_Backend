package com.codegym.controller;

import com.codegym.dto.MovieDto;
import com.codegym.model.Movie;
import com.codegym.service.IMovieService;
import com.codegym.service.ISeatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "https://localhost:4200", allowedHeaders = "*")
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


    @PostMapping("movie/create")
    public ResponseEntity<?> createMovie(@RequestBody Movie movie) {
//        BeanUtils.copyProperties(movie, movieDto);
        try {
            iMovieService.save(movie);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("movie/edit/{id}")
    public ResponseEntity<HttpStatus> editSupplies(@Valid @RequestBody MovieDto movieDto, BindingResult bindingResult1) {
        List<Movie> movieList = iMovieService.findAll();
        movieDto.setMovieList(movieList);
        movieDto.validate(movieDto, bindingResult1);
        if (bindingResult1.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Movie movie = new Movie();
            String name = movieDto.getName().trim();
            String content = movieDto.getContent().trim();
            String director = movieDto.getDirector().trim();
            String actor = movieDto.getActor().trim();
            movieDto.setName(name);
            movieDto.setContent(content);
            movieDto.setDirector(director);
            movieDto.setActor(actor);
            BeanUtils.copyProperties(movieDto, movie);
            movie.setId(movieDto.getId());
            iMovieService.save(movie);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("movie/findById/{id}")
    public ResponseEntity<Movie> getSupplies(@PathVariable Long id) {
        Optional<Movie> movie = iMovieService.findById(id);
        if (movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
