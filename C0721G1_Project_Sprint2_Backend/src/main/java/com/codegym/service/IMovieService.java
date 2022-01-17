package com.codegym.service;

import com.codegym.model.Movie;

public interface IMovieService extends IGeneralService<Movie> {
    void save(Movie movie);
}
