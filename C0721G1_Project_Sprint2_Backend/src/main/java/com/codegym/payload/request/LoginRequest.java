package com.codegym.payload.request;

/*
Creator: TanTN
 */
public class LoginRequest {
    private String username;

    private String password;
    private String provider;
    private String photoUrl;
    private String name;
    private String email;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password, String provider, String photoUrl, String name, String email) {
        this.username = username;
        this.password = password;
        this.provider = provider;
        this.photoUrl = photoUrl;
        this.name = name;
        this.email = email;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
