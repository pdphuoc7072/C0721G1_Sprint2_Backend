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
public class StatisticsController_UserStats {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getUserStats_11() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/user/stats/2021-03-15/2021-03-17"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
//        .andExpect((ResultMatcher) jsonPath("$.getCode_user").value("TV0010"))
//        .andExpect((ResultMatcher) jsonPath("$.getName_user").value("Triệu Vân"))
//        .andExpect((ResultMatcher) jsonPath("$.getMoney").value("500000"))
//        .andExpect((ResultMatcher) jsonPath("$.getTicket").value("1"))
//        .andExpect((ResultMatcher) jsonPath("$.getPoint").value("500.0000"))
        ;
    }



    @Test
    public void getUserStats_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/stats/2018-03-15/2019-03-17"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void getUserStats_9_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/user/stats"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void getUserStats_9_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/stats?", "startDate=2018-11-11"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void getUserStats_9_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/stats?", "endDate=2021-12-11"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void getListFinancial_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/stats?", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListFinancial_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/stats?", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}


