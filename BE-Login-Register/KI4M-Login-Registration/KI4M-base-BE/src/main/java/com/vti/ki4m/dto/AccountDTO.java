package com.vti.ki4m.dto;

import com.vti.ki4m.entity.Account;

public class AccountDTO {

    private String username;
    private String email;
    private String password;
    private String fullName;

    public AccountDTO() {

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

    public Account toEntity() {
        return new Account(username, email, password, fullName);
    }
}
