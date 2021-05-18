package com.example.demo.Register.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Turisti{
    @Id
    @Column
    private int turistiID;
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


    public Turisti(int turistiID, String name, String surname, int age, char gender, String email, String password) {
        this.turistiID = turistiID;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public int getTuristiID() {
        return turistiID;
    }

    public void setTuristiID(int turistiID) {
        this.turistiID = turistiID;
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
}

