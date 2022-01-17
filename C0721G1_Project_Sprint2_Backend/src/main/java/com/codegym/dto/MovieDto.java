package com.codegym.dto;

import com.codegym.model.Category;
import com.codegym.model.Movie;
import com.codegym.model.Schedule;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

public class MovieDto implements Validator {
    private Long id;
    private String image;
    private String name;
    @Pattern(regexp = "\\d{4}[-]((([0]{1})([1-9]{1}))|(([1]{1})([0-2]{1})))[-]((([0]{1})([1-9]{1}))|(([1-2]{1})([0-9]{1}))|(([3]{1})([0-1]{1})))",
            message = "Please enter the correct format for start date 'DD/MM/YYYY'")
    private String startDate;
    @Pattern(regexp = "\\d{4}[-]((([0]{1})([1-9]{1}))|(([1]{1})([0-2]{1})))[-]((([0]{1})([1-9]{1}))|(([1-2]{1})([0-9]{1}))|(([3]{1})([0-1]{1})))",
            message = "Please enter the correct format for end date 'DD/MM/YYYY'")
    private String endDate;
    private String actor;
    private String studio;
    private String duration;
    private String director;
    private String version;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String trailer;
    private String hall;
    private List<Category> categories;
    private List<Schedule> schedules;
    private List<Movie> movieList;

    public MovieDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
