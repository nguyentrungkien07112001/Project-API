package com.vti.ki4m.dto;

import com.vti.ki4m.entity.Account;

public class AccountDTO {

    private String token;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String role;
    private String status;

    public AccountDTO() {

    }

    public AccountDTO(String token, String username, String email, String password, String fullName, String role, String status) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Account toEntity() {
        return new Account(username, email, password, fullName);
    }
}
