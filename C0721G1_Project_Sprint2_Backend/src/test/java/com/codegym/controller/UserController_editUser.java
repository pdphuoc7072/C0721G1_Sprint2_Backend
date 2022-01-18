package com.codegym.controller;


import com.codegym.dto.UserDTO;

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
public class UserController_editUser {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    //    item = null
    @Test
    public void editUser_19() throws Exception {
        UserDTO userDto = new UserDTO();
        userDto.setId((long) 1);
        userDto.setUsername("namnguyen123");
        userDto.setPassword("1234");
        userDto.setImage("abc.png");
        userDto.setCode("NV-001");
        userDto.setName(null);
        userDto.setBirthday("03/03/1991");
        userDto.setGender(1);
        userDto.setPoint(2500);
        userDto.setIdCard("987654321");
        userDto.setEmail("namnguyen@gmail.com");
        userDto.setPhone("0905545434");
        userDto.setAddress("Sài Gòn");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    item = rong

    @Test
    public void editUser_20() throws Exception {
        UserDTO userDto = new UserDTO();
        userDto.setId((long) 1);
        userDto.setUsername("namnguyen123");
        userDto.setPassword("1234");
        userDto.setImage("abc.png");
        userDto.setCode("NV-001");
        userDto.setName("");
        userDto.setBirthday("03/03/1991");
        userDto.setGender(1);
        userDto.setPoint(2500);
        userDto.setIdCard("987654321");
        userDto.setEmail("namnguyen@gmail.com");
        userDto.setPhone("0905545434");
        userDto.setAddress("Sài Gòn");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


//    item sai format

    @Test
    public void editUser_21() throws Exception {
        UserDTO userDto = new UserDTO();
        userDto.setId((long) 1);
        userDto.setUsername("namnguyen123");
        userDto.setPassword("1234");
        userDto.setImage("abc.png");
        userDto.setCode("NV-001");
        userDto.setName("Nguyễn Văn Nam");
        userDto.setBirthday("03/03/1991");
        userDto.setGender(1);
        userDto.setPoint(2500);
        userDto.setIdCard("987654321");
        userDto.setEmail("namnguygdf53453$%%");
        userDto.setPhone("0905545434");
        userDto.setAddress("Sài Gòn");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //    item khong >= minlength
    @Test
    public void editUser_22() throws Exception {
        UserDTO userDto = new UserDTO();
        userDto.setId((long) 1);
        userDto.setUsername("namnguyen123");
        userDto.setPassword("1234");
        userDto.setImage("abc.png");
        userDto.setCode("NV-001");
        userDto.setName("N");
        userDto.setBirthday("03/03/1991");
        userDto.setGender(1);
        userDto.setPoint(2500);
        userDto.setIdCard("987654321");
        userDto.setEmail("namnguyen@gmail.com");
        userDto.setPhone("0905545434");
        userDto.setAddress("Sài Gòn");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    item khong <= maxlength

    @Test
    public void editUser_23() throws Exception {
        UserDTO userDto = new UserDTO();
        userDto.setId((long) 1);
        userDto.setUsername("namnguyen123");
        userDto.setPassword("1234");
        userDto.setImage("abc.png");
        userDto.setCode("NV-001");
        userDto.setName("Nguyễn Văn Namdgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg annnnnnnn");
        userDto.setBirthday("03/03/1991");
        userDto.setGender(1);
        userDto.setPoint(2500);
        userDto.setIdCard("987654321");
        userDto.setEmail("namnguyen@gmail.com");
        userDto.setPhone("0905545434");
        userDto.setAddress("Sài Gòn");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    All item deu hop le

    @Test
    public void editUser_24() throws Exception {
        UserDTO userDto = new UserDTO();
        userDto.setId((long) 1);
        userDto.setUsername("namnguyen123");
        userDto.setPassword("1234");
        userDto.setImage("abc.png");
        userDto.setCode("NV-001");
        userDto.setName("Nguyễn Văn Nam");
        userDto.setBirthday("03/03/1991");
        userDto.setGender(1);
        userDto.setPoint(2500);
        userDto.setIdCard("987654321");
        userDto.setEmail("namnguyen@gmail.com");
        userDto.setPhone("0905545434");
        userDto.setAddress("Sài Gòn");

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}
