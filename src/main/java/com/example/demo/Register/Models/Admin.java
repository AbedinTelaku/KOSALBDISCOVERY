package com.example.demo.Register.Models;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Configuration
@EnableAutoConfiguration
@Entity
public class Admin {
    @Id
    @Column
    private int adminID;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @Column
    private String username;
    @Column
    private char gender;
    @Column
    private String email;
    @Column
    private String password;

    public Admin(int adminID, String name, String surname, int age, String username, char gender, String email, String password) {
        this.adminID = adminID;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
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
}

