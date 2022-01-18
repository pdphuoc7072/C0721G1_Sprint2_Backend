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
public class MovieRestController_CreateMovie {
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createMovie_name_13() throws Exception {
        MovieDto movieDto = new MovieDto();
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createMovie_name_14() throws Exception {
        MovieDto movieDto = new MovieDto();
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createMovie_content_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setName("");
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createMovie_duration_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setName("");
        movieDto.setImage("https://upload.wikimedia.org/wikipedia/vi/b/b0/Avatar-Teaser-Poster.jpg");
        movieDto.setActor("Sam");
        movieDto.setContent("AAAAAAAAAAAAA");
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/movie/create")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createMovie_name_18() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setName("Ironman");
        movieDto.setImage("https://upload.wikimedia.org/wikipedia/vi/b/b0/Avatar-Teaser-Poster.jpg");
        movieDto.setActor("Sam");
        movieDto.setContent("AAAAAAAAAAAAA");
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
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/movie/create")
                .content(this.objectMapper.writeValueAsString(movieDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
