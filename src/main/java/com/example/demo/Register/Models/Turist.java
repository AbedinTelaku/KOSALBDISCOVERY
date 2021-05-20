package com.example.demo.Register.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Turist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int turistID;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @Column
    private char gender;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String role;


    public Turist(int turistID, String name, String surname, int age, char gender, String email, String password, String role) {
        this.turistID = turistID;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.role=role;
    }
    public Turist() {

    }
    public int getTuristID() {
        return turistID;
    }

    public void setTuristID(int turistID) {
        this.turistID = turistID;
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
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

