package com.codegym.service;


import com.codegym.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMovieService extends IGeneralService<Movie> {
    Page<Movie> findUpComingMovies(Pageable pageable);
    Page<Movie> findOnShowingAndSearchMovies(String name, String categoryId, Pageable pageable);
}
