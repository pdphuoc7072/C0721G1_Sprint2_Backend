package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PointController_getAllById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListPoints_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/user/points"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListPoints_6() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/user/points"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())

                .andExpect(jsonPath("$.getDate()").value("2022-01-13"))
                .andExpect(jsonPath("$.getName()").value("Spider-Man: No Way Home"))
                .andExpect(jsonPath("$.getPoint()").value("100"));
    }

    @Test
    public void getListPoints_11() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/points/fetch?","startDate=2021-11-11&endDate=2021-12-12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.getDate()").value("2021-12-12"))
                .andExpect(jsonPath("$.getName()").value("No Time To Die"))
                .andExpect(jsonPath("$.getPoint()").value("100"));
    }

    @Test
    public void getListPoints_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/points/fetch?","startDate=2021-11-11&endDate=2021-12-12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void getListPoints_08() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/points/fetch?","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListPoints_07() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/points/fetch?",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
