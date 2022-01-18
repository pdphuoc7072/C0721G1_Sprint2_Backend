package com.codegym.controller;

import com.codegym.dto.UserCreateDTO;
import com.codegym.model.User;
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

@SpringBootTest
@AutoConfigureMockMvc
public class UserController_createUser {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createUser_name_13() throws Exception {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername(null);
        userCreateDTO.setPassword("12345");
        userCreateDTO.setName("Dương Nhật Sang 123");
        userCreateDTO.setPhone("0909999111");
        userCreateDTO.setBirthday("2000-10-16");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("123456789");
        userCreateDTO.setEmail("sang@gmail.com");
        userCreateDTO.setAddress("Huế");
        userCreateDTO.setImage("bbbb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/user/create")
                .content(this.objectMapper.writeValueAsString(userCreateDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createUser_name_14() throws Exception {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("");
        userCreateDTO.setPassword("12345");
        userCreateDTO.setName("Dương Nhật Sang 123");
        userCreateDTO.setPhone("0909999111");
        userCreateDTO.setBirthday("2000-10-16");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("123456789");
        userCreateDTO.setEmail("sang@gmail.com");
        userCreateDTO.setAddress("Huế");
        userCreateDTO.setImage("bbbb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/user/create")
                .content(this.objectMapper.writeValueAsString(userCreateDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createUser_name_15() throws Exception {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("sangdeptrai@..");
        userCreateDTO.setPassword("12345");
        userCreateDTO.setName("Dương Nhật Sang");
        userCreateDTO.setPhone("0909999111");
        userCreateDTO.setBirthday("2000-10-16");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("123456789");
        userCreateDTO.setEmail("sang@gmail.com");
        userCreateDTO.setAddress("Huế");
        userCreateDTO.setImage("bbbb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/user/create")
                .content(this.objectMapper.writeValueAsString(userCreateDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createUser_name_16() throws Exception {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("sang");
        userCreateDTO.setPassword("12345");
        userCreateDTO.setName("Dương Nhật Sang");
        userCreateDTO.setPhone("0909999111");
        userCreateDTO.setBirthday("2000-10-16");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("123456789");
        userCreateDTO.setEmail("sang@gmail.com");
        userCreateDTO.setAddress("Huế");
        userCreateDTO.setImage("bbbb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/user/create")
                .content(this.objectMapper.writeValueAsString(userCreateDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createUser_name_17() throws Exception {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("sanggggggggggggggggggggggggggg");
        userCreateDTO.setPassword("12345");
        userCreateDTO.setName("Dương Nhật Sang");
        userCreateDTO.setPhone("0909999111");
        userCreateDTO.setBirthday("2000-10-16");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("123456789");
        userCreateDTO.setEmail("sang@gmail.com");
        userCreateDTO.setAddress("Huế");
        userCreateDTO.setImage("bbbb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/user/create")
                .content(this.objectMapper.writeValueAsString(userCreateDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createUser_name_18() throws Exception {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUsername("sangduong");
        userCreateDTO.setPassword("12345");
        userCreateDTO.setName("Dương Nhật Sang");
        userCreateDTO.setPhone("0909999111");
        userCreateDTO.setBirthday("2000-10-16");
        userCreateDTO.setGender(1);
        userCreateDTO.setIdCard("123456789");
        userCreateDTO.setEmail("sang@gmail.com");
        userCreateDTO.setAddress("Huế");
        userCreateDTO.setImage("bbbb");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/user/create")
                .content(this.objectMapper.writeValueAsString(userCreateDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
