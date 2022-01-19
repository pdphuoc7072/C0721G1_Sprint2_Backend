package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(
//        classes = { ConfigTest.class, PersistenceJPAConfig.class },
//        loader = AnnotationConfigContextLoader.class)
public class UserController_changePassword {
    private final String URL_PREFIX = "http://localhost:8080/";
    private final String URL = URL_PREFIX + "/user/change-password/{id}";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    IUserService iUserService;

  
    @Test
    public void changePassword_21() throws Exception {

        UserDto userDto = new UserDto();

        Optional<User> userCurrent = iUserService.findById(userDto.getId());
        if(userCurrent.get().getPassword().equals(userDto.getPassword())){
            this.mockMvc
                    .perform(MockMvcRequestBuilders
                            .post("/user/change-password/{id}/{oldPassword}/{newPassword}")
                            .content(this.objectMapper.writeValueAsString(userDto))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        }


    }
    @Test
    public void changePassword_1() throws Exception {

        UserDto userDto = new UserDto();

        userDto.setPassword("1b");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/user/change-password/{id}/{oldPassword}/{newPassword}")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void changePassword_23() throws Exception {

        UserDto userDto = new UserDto();

        userDto.setPassword("1b11111111111");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/user/change-password/{id}/{oldPassword}/{newPassword}")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void changePassword_24() throws Exception {

        UserDto userDto = new UserDto();

        userDto.setPassword("binhCode@Gym");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/user/change-password/{id}/{oldPassword}/{newPassword}")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




}
