package com.codegym.service;

import com.codegym.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMovieService extends IGeneralService<Movie> {
    List<Movie> getAll();

    boolean existsByIdMovie(Long id);

    Page<Movie> findAllMovie(String name, Pageable pageable);
}
