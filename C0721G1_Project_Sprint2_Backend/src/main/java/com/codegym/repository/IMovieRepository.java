package com.codegym.repository;

import com.codegym.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM movie WHERE`name` LIKE :name ", nativeQuery = true)
    Page<Movie> findAllMovie( @Param("name") String name, Pageable pageable);
}
