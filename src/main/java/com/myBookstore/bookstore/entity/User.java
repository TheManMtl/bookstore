package com.myBookstore.bookstore.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;



@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;


    private String password;


    private String fullName;


    private String email;


    private int enabled;

    public User() {
    }

    public User(String username, String password, String fullName, String email, int enabled) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.enabled = enabled;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
