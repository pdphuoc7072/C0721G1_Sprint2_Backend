package com.codegym.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
    private Long id;
    @NotBlank
    @Size(max = 30, min = 2)
    private String userName;
    @NotBlank
    @Size(max = 30, min = 2)
    private String password;
    @NotBlank
    private String image;
    @NotBlank
    private String code;
    @NotBlank
    private String name;
    @NotBlank
    private String birthday;
    @NotNull
    private Integer gender;
    private Integer point;
    @NotBlank
    private String idCard;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;

    public UserDto() {
    }

    public UserDto(Long id, @NotBlank @Size(max = 30, min = 2) String userName, @NotBlank @Size(max = 30, min = 2) String password, @NotBlank String image, @NotBlank String code, @NotBlank String name, @NotBlank String birthday, @NotNull Integer gender, Integer point, @NotBlank String idCard, @NotBlank String email, @NotBlank String phone, @NotBlank String address) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.image = image;
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.point = point;
        this.idCard = idCard;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
