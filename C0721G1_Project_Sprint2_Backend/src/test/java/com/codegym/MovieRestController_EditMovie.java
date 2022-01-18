package com.codegym;


import com.codegym.dto.MovieDto;
import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieRestController_EditMovie {
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void editMovie_name_19() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setId((long) 1);
        movieDto.setName(null);
        movieDto.setImage("https://upload.wikimedia.org/wikipedia/vi/b/b0/Avatar-Teaser-Poster.jpg");
        movieDto.setActor("Sam");
        movieDto.setContent("AAAA");
        movieDto.setDirector("Michael");
        movieDto.setDuration("200");
        movieDto.setStartDate("2022-02-02");
        movieDto.setEndDate("2022-02-05");
        movieDto.setHall("1A");
        movieDto.setVersion("2D");
        movieDto.setTrailer("https://www.youtube.com/watch?v=6ziBFh3V1aM");
        movieDto.setStudio("CenturyFox");
        List<Category> category = iCategoryService.findAll();
        movieDto.setCategories(category);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/movie/edit")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editMovie_name_20() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setId((long) 1);
        movieDto.setName("");
        movieDto.setImage("https://upload.wikimedia.org/wikipedia/vi/b/b0/Avatar-Teaser-Poster.jpg");
        movieDto.setActor("Sam");
        movieDto.setContent("AAAA");
        movieDto.setDirector("Michael");
        movieDto.setDuration("200");
        movieDto.setStartDate("2022-02-02");
        movieDto.setEndDate("2022-02-05");
        movieDto.setHall("1A");
        movieDto.setVersion("2D");
        movieDto.setTrailer("https://www.youtube.com/watch?v=6ziBFh3V1aM");
        movieDto.setStudio("CenturyFox");
        List<Category> category = iCategoryService.findAll();
        movieDto.setCategories(category);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/movie/edit")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editMovie_content_22() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setId((long) 1);
        movieDto.setName("Iron man");
        movieDto.setImage("https://upload.wikimedia.org/wikipedia/vi/b/b0/Avatar-Teaser-Poster.jpg");
        movieDto.setActor("Sam");
        movieDto.setContent("A");
        movieDto.setDirector("Michael");
        movieDto.setDuration("200");
        movieDto.setStartDate("2022-02-02");
        movieDto.setEndDate("2022-02-05");
        movieDto.setHall("1A");
        movieDto.setVersion("2D");
        movieDto.setTrailer("https://www.youtube.com/watch?v=6ziBFh3V1aM");
        movieDto.setStudio("CenturyFox");
        List<Category> category = iCategoryService.findAll();
        movieDto.setCategories(category);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/movie/edit")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editMovie_duration_23() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setId((long) 1);
        movieDto.setName("Iron man");
        movieDto.setImage("https://upload.wikimedia.org/wikipedia/vi/b/b0/Avatar-Teaser-Poster.jpg");
        movieDto.setActor("Sam");
        movieDto.setContent("AAAAAAAAAAA");
        movieDto.setDirector("Michael");
        movieDto.setDuration("400");
        movieDto.setStartDate("2022-02-02");
        movieDto.setEndDate("2022-02-05");
        movieDto.setHall("1A");
        movieDto.setVersion("2D");
        movieDto.setTrailer("https://www.youtube.com/watch?v=6ziBFh3V1aM");
        movieDto.setStudio("CenturyFox");
        List<Category> category = iCategoryService.findAll();
        movieDto.setCategories(category);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/movie/edit")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editMovie_24() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setId((long) 1);
        movieDto.setName("Iron man");
        movieDto.setImage("https://upload.wikimedia.org/wikipedia/vi/b/b0/Avatar-Teaser-Poster.jpg");
        movieDto.setActor("Sam");
        movieDto.setContent("AAAAAAAAAAA");
        movieDto.setDirector("Michael");
        movieDto.setDuration("200");
        movieDto.setStartDate("2022-02-02");
        movieDto.setEndDate("2022-02-05");
        movieDto.setHall("1A");
        movieDto.setVersion("2D");
        movieDto.setTrailer("https://www.youtube.com/watch?v=6ziBFh3V1aM");
        movieDto.setStudio("CenturyFox");
        List<Category> category = iCategoryService.findAll();
        movieDto.setCategories(category);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/movie/edit")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}