package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieController_getListHourShowByIdMovie {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListHourShowByIdMovie_1() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/movie/{id}/hour-show", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListHourShowByIdMovie_2() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/movie/{id}/hour-show", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListHourShowByIdMovie_3() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/movie/{id}/hour-show", "100"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getListHourShowByIdMovie_4() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/movie/{id}/hour-show", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
