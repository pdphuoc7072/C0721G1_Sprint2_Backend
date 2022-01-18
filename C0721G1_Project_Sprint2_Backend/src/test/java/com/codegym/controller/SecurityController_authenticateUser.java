package com.codegym.controller;

import ch.qos.logback.core.boolex.Matcher;
import com.codegym.payload.request.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityController_authenticateUser {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /*
    username: null
     */
    @Test
    public void authenticateUser_username_13() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(null);
        loginRequest.setPassword("123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
    password: null
     */
    @Test
    public void authenticateUser_password_13() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
    username: null, password: null
     */
    @Test
    public void authenticateUser_13() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(null);
        loginRequest.setPassword(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
    username: rỗng
     */
    @Test
    public void authenticateUser_username_14() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("");
        loginRequest.setPassword("123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
    password: rỗng
     */
    @Test
    public void authenticateUser_password_14() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
    username: rỗng, password: rỗng
     */
    @Test
    public void authenticateUser_14() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("");
        loginRequest.setPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
    Vì Login bằng phương thức post, nên không có check đúng format, minlenth, maxlength. Thay vào đó sẽ có 4 trường hợp
    (trong đó có 3 trường hợp sai (từ 15-17), và 1 trường hợp đúng (18))
     */
    /*
    Username: đúng, password: sai
     */
    @Test
    public void authenticateUser_15() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
    Username: sai, password: đúng
     */
    @Test
    public void authenticateUser_16() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin1");
        loginRequest.setPassword("admin");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
    Username: sai, password: sai
     */
    @Test
    public void authenticateUser_17() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin1");
        loginRequest.setPassword("123456789");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
    Username: đúng, password: đúng
     */
    @Test
    public void authenticateUser_18() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("admin");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.type").value("Bearer"))
                .andExpect(jsonPath("$.username").value("admin"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.roles", hasSize(2)))
                .andExpect(jsonPath("$.user.id").value(1))
                .andExpect(jsonPath("$.user.username").value("admin"))
                .andExpect(jsonPath("$.user.password").value("$2a$12$psNTpWJhASdJmyJ3RbvMKead2IVQa.afBHrNRHmVe63G3G5V40w4i"))
                .andExpect(jsonPath("$.user.image").value("https://lh3.googleusercontent.com/ogw/ADea4I47IeL5kIEEeg07JaF7myrkO2Cz45g8ackvNaax=s83-c-mo"))
                .andExpect(jsonPath("$.user.code").value("TK-0001"))
                .andExpect(jsonPath("$.user.name").value("Tân Trần"))
                .andExpect(jsonPath("$.user.birthday").value("2000-01-01"))
                .andExpect(jsonPath("$.user.gender").value(1))
                .andExpect(jsonPath("$.user.point").value(9999999))
                .andExpect(jsonPath("$.user.phone").value("0947829245"))
                .andExpect(jsonPath("$.user.address").value("Đà Nẵng"))
                .andExpect(jsonPath("$.user.idCard").value("201605626"))
                .andExpect(jsonPath("$.user.email").value("tancodegym@gmail.com"));
    }


}
