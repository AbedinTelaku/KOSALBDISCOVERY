package com.example.demo.Core.Entities;

import javax.persistence.Embeddable;


@Embeddable
public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
