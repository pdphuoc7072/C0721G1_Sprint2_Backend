package com.codegym.repository;

import com.codegym.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
}
