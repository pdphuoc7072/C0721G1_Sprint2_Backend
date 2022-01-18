package com.codegym.dto;

import com.codegym.model.Category;
import com.codegym.model.Movie;
import com.codegym.model.Schedule;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MovieDto implements Validator {
    private Long id;
    @NotBlank(message = "Trường này không được để trống!")
    private String image;
    @NotBlank(message = "Trường này không được để trống!")
    private String name;
    @NotBlank(message = "Trường này không được để trống!")
    @Pattern(regexp = "\\d{4}[-]((([0]{1})([1-9]{1}))|(([1]{1})([0-2]{1})))[-]((([0]{1})([1-9]{1}))|(([1-2]{1})([0-9]{1}))|(([3]{1})([0-1]{1})))",
            message = "Please enter the correct format for start date 'DD/MM/YYYY'")
    private String startDate;
    @NotBlank(message = "Trường này không được để trống!")
    @Pattern(regexp = "\\d{4}[-]((([0]{1})([1-9]{1}))|(([1]{1})([0-2]{1})))[-]((([0]{1})([1-9]{1}))|(([1-2]{1})([0-9]{1}))|(([3]{1})([0-1]{1})))",
            message = "Please enter the correct format for end date 'DD/MM/YYYY'")
    private String endDate;
    @NotBlank
    @NotBlank(message = "Trường này không được để trống!")
    private String actor;
    @NotBlank
    @NotBlank(message = "Trường này không được để trống!")
    private String studio;
    @NotBlank
    @NotBlank(message = "Trường này không được để trống!")
    @Max(value = 250)
    private String duration;
    @NotBlank
    @NotBlank(message = "Trường này không được để trống!")
    private String director;
    @NotBlank
    @NotBlank(message = "Trường này không được để trống!")
    private String version;
    @Column(columnDefinition = "TEXT")
    @NotBlank
    @NotBlank(message = "Trường này không được để trống!")
    @Size(max = 500, min = 10)
    private String content;
    @NotBlank
    @NotBlank(message = "Trường này không được để trống!")
    private String trailer;
    @NotBlank
    @NotBlank(message = "Trường này không được để trống!")
    private String hall;
    private List<Category> categories;
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
        MovieDto movieDto = (MovieDto) target;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(movieDto.startDate);
            Date endDate = sdf.parse(movieDto.endDate);
            Date now = sdf.parse(String.valueOf(LocalDate.now()));
            if (startDate.compareTo(now) <= 0) {
                errors.rejectValue("startDate", "SDF", "Ngày bắt đầu phải trước ngày hiện tại!");
            }
            if (endDate.compareTo(now) <= 0) {
                errors.rejectValue("endDate", "EDF", "Ngày kết thúc phải sau ngày hiện tại!");
            }
            if (endDate.compareTo(startDate) <= 0) {
                errors.rejectValue("startDate", "SDM", "Ngày bắt đầu phải trước ngày kết thúc!");
                errors.rejectValue("endDate", "EDM", "Ngày kết thúc phải sau ngày bắt đầu !");

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
