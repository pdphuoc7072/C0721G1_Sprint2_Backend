package com.codegym.service.impl;

import com.codegym.model.Movie;
import com.codegym.repository.IMovieRepository;
import com.codegym.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements IMovieService {
    @Autowired
    private IMovieRepository iMovieRepository;

    @Override
    public List<Movie> findAll() {
        return iMovieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return iMovieRepository.findById(id);
    }

    @Override
    public void save(Movie movie) {
        iMovieRepository.save(movie);
    }

    @Override
    public void remove(Long id) {
        iMovieRepository.deleteById(id);
    }

}
