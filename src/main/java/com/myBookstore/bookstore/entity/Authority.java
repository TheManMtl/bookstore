package com.myBookstore.bookstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @NotEmpty(message = "Username cannot be empty")
    @Size(max = 255, min = 5, message = "Username cannot exceed 255 characters and must be over 5")
    @Column(name = "username")
    private String username;


    @NotEmpty(message = "Authority cannot be empty")
    @Column(name = "authority")
    private String authority;

    public Authority() {
    }

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "username='" + username + '\'' +
                ", authority=" + authority +
                '}';
    }
}