package com.codegym.service;

import com.codegym.dto.MovieStatsDTO;
import com.codegym.model.Movie;

import java.util.List;

public interface IMovieService extends IGeneralService<Movie> {
    List<MovieStatsDTO> getMovieStats();
}
