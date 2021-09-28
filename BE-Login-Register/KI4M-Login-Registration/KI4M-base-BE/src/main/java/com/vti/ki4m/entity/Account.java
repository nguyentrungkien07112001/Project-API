package com.vti.ki4m.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Account")
public class Account implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "`username`", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "`email`", length = 50, unique = true, nullable = false)
    private String email;

    @Column(name = "`password`", length = 800, nullable = false)
    private String password;

    @Column(name = "fullName", length = 50, nullable = false)
    private String fullName;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "`status`", nullable = false)
    private AccountStatus status = AccountStatus.NOT_ACTIVE;

    @Column(name = "`role`", nullable = false)
    private String role;

    public Account() {

    }

    public Account(String username, String email, String password, String fullName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role = "User";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
