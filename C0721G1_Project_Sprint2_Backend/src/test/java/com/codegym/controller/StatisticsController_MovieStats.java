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
public class StatisticsController_MovieStats {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getMovieStats_11() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movie/stats/2021-03-11/2021-03-15"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
//                .andExpect((ResultMatcher) jsonPath("$.getName_movie").value("MA TRẬN: HỒI SINH"))
//                .andExpect((ResultMatcher) jsonPath("$.getMoney").value("500000"))
//                .andExpect((ResultMatcher) jsonPath("$.getTicket").value("1"));
    }

   


    @Test
    public void getLMovieStats_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/movie/stats/2018-11-11/2019-12-12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getLMovieStats_9_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/movie/stats?", "startDate=2018-11-11"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getLMovieStats_9_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/movie/stats?", "endDate=2022-12-12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getMovieStats_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/movie/stats?", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getMovieStats_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/movie/stats?", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
