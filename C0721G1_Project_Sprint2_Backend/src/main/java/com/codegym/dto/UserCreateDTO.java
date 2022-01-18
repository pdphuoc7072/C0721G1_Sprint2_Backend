package com.codegym.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserCreateDTO {

    @NotBlank
    @Size(max = 30, min = 6 ,message = "Tên tài khoản phải từ 6 đến 30 kí tự")
    @Pattern(regexp = "[\\w0-9]*",message = "Tên tài khoản có chứa kí tự số hoặc kí tự đặc biệt")
    private String username;
    @NotBlank
    private String password;

    private String image;

    private String code;


    @NotBlank
    @Size(max = 30, min = 2,message = "Họ và tên phải từ 2 đến 30 kí tự")
    @Pattern(regexp = "(\\p{L}+[\\p{L}\\s]*)", message = "Tên có chứa kí tự số hoặc kí tự đặc biệt")
    private String name;


    @NotBlank
    private String birthday;

    private Integer gender;
    @NotBlank
    private String idCard;


    @NotBlank
    @Pattern(regexp = "[a-z]+[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+\\.*[a-zA-Z0-9]*)",message = "Email không đúng định dạng")
    private String email;


    @NotBlank
    @Pattern(regexp = "^((090)|(091))[\\d]{7}$",
            message = "Số điện thoại phải bắt đầu bằng 090xxxxxxx or 091xxxxxxx")
    private String phone;
    @NotBlank
    private String address;

    public UserCreateDTO() {
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
