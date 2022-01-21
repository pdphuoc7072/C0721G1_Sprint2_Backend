package com.codegym.dto;

import com.codegym.model.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDTO implements Validator {
    private Long id;

    private String username;

    @NotBlank(message = "Trường này không được để trống!")
    private String password;

    private String image;

    private String code;

    @NotBlank(message = "Trường này không được để trống!")
    @Size(max = 30, min = 2)
    @Pattern(regexp = "(\\p{L}+[\\p{L}\\s]*)", message = "Tên có chứa kí tự số hoặc kí tự đặc biệt")
    private String name;

    @NotBlank(message = "Trường này không được để trống!")
//    @Pattern(regexp = "^(?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])[-/.](?:19\\d{2}|20\\d{2})$",
//            message = "Phải đúng định dạng: mm-dd-yyyy!")
    private String birthday;


    @NotNull
    private Integer gender;

    private Integer point;


    private String idCard;


    @NotBlank(message = "Trường này không được để trống!")
//    @Pattern(regexp = "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$",
//            message = "Email phải đúng định dạng")
    private String email;

    @NotBlank(message = "Trường này không được để trống!")
    private String phone;


    @NotBlank(message = "Trường này không được để trống!")
    private String address;

    List<User> userList = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

