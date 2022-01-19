package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserController_editInfomation {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void editUser_name_13() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName(null);
        userDto.setPhone("0909999111");
        userDto.setBirthday("2000-10-16");
        userDto.setAddress("Huế");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editUser_birthDay_13() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("Nguyễn văn a");
        userDto.setPhone("0909999111");
        userDto.setBirthday(null);
        userDto.setGender(0);
        userDto.setAddress("Huế");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //[item] = null
    @Test
    public void editUser_phone_13() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("Nguyễn văn a");
        userDto.setPhone(null);
        userDto.setBirthday("2000-01-01");
        userDto.setGender(0);
        userDto.setAddress("Huế");
        userDto.setImage("anh1.png");;
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editUser_address_13() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("Nguyễn văn a");
        userDto.setPhone("0909999111");
        userDto.setBirthday("2000-05-03");
        userDto.setGender(0);
        userDto.setAddress(null);
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void  editUser_Name_14() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("");
        userDto.setPhone("0909999111");
        userDto.setBirthday("2000-10-16");
        userDto.setGender(0);
        userDto.setAddress("Huế");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //[item] = rỗng
    @Test
    public void editUser_birthDay_14() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("Nguyễn văn a");
        userDto.setPhone("0909999111");
        userDto.setBirthday("");
        userDto.setGender(0);
        userDto.setAddress("Huế");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editUser_phone_14() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("Nguyễn văn a");
        userDto.setPhone("");
        userDto.setBirthday("2000-01-01");
        userDto.setGender(0);
        userDto.setAddress("Huế");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editUser_Address_14() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("Nguyễn văn a");
        userDto.setPhone("0909999111");
        userDto.setBirthday("2000-05-03");
        userDto.setGender(0);
        userDto.setAddress("");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //[item] sai format
    @Test
    public void  editUser_Name_15() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("Nguyen van 123");
        userDto.setPhone("0909999111");
        userDto.setBirthday("2000-10-16");
        userDto.setGender(0);
        userDto.setAddress("Huế");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //[item] không đủ điều kiện
    @Test
    public void editUser_BirthDay_15() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("Nguyễn văn a");
        userDto.setPhone("0909999111");
        userDto.setBirthday("2000/01/01");
        userDto.setGender(0);
        userDto.setAddress("Huế");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editUser_Phone_15() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("Nguyễn văn a");
        userDto.setPhone("098566677799");
        userDto.setBirthday("2000-01-01");
        userDto.setGender(0);
        userDto.setAddress("Huế");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void  editUser_Name_16() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("a");
        userDto.setPhone("0909999111");
        userDto.setBirthday("2000-10-16");
        userDto.setGender(0);
        userDto.setAddress("Huế");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void  editUser_name_17() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("Nguyen van aaaaaaaaaaaaaaaaaaaaaaaaa");
        userDto.setPhone("0909999111");
        userDto.setBirthday("2000-10-16");
        userDto.setGender(0);
        userDto.setAddress("Huế");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void  editUser_name_18() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId((long) 1);
        userDto.setName("Nguyen Van An");
        userDto.setPhone("0909999999");
        userDto.setBirthday("2000-10-16");
        userDto.setGender(0);
        userDto.setAddress("Đà Nẵng");
        userDto.setImage("anh1.png");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/update/{id}")
                .content(this.objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}

