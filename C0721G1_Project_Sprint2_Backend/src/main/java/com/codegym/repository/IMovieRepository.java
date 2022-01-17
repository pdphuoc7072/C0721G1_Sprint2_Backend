package com.codegym.repository;

import com.codegym.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

    //    phim dang chieu
//    @Query(value = "SELECT * FROM movie " +
//            "WHERE start_date <= now() " +
//            "AND end_date >= now() " +
//            "ORDER BY start_date DESC", nativeQuery = true)
//    Page<Movie> findOnShowingMovies(Pageable pageable);

    //    phim sap chieu
    @Query(value = "SELECT * FROM movie " +
            "WHERE start_date > now() " +
            "ORDER BY start_date", nativeQuery = true)
    Page<Movie> findUpComingMovies(Pageable pageable);


    @Query(value = "Select * from movie  " +
            "Join movie_category  on movie.id = movie_category.movie_id" +
            " where start_date<=now() and end_date >= now()" +
            "and movie.name like :name" +
            " and movie_category.category_id like :category_id " +
            "ORDER BY start_date DESC ",nativeQuery = true)
    Page<Movie> findOnShowingAndSearchMovies(@Param("name") String name, @Param("category_id") String category_id,
                                              Pageable pageable);
}
