package com.example.demo.Core.Entities;

import javax.persistence.Embeddable;


@Embeddable
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
