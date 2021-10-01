package com.vti.ki4m.dto;

public class LoginInforAccount {
    private String token;
    private String username;
    private String email;
    private String fullName;
    private String role;
    private String status;

    public LoginInforAccount(String token, String username, String email, String fullName, String role, String status) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }
}
