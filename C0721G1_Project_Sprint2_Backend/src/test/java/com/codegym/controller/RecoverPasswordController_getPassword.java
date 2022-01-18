package com.codegym.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class RecoverPasswordController_getPassword {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void getPassword_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.
                        post("/api/public/password/{email}", "tan09qlmt@gmail.com"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getPassword_1() throws  Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.  get("/api/public/password/{email}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPassword_2() throws  Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.  get("/api/public/password/{email}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPassword_3() throws  Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/public/password/{email}", "dfsdfsd"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
