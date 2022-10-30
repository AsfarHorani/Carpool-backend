package com.carpool.dto;

public class UserDto {
    private String address;
    private String password;

    public String getUsername() {
        return address;
    }
    
    public void setUsername(String username) {
        this.address = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
