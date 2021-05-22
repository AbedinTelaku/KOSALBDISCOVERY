package com.example.demo.Register.Helper;


import java.io.Serializable;

public class BusinessHelper implements Serializable {

    private String name;
    private String email;
    private String password;
    private String username;
    private String tel_Number;
    private String owner_ID;
    private String fiscal_Number;
    private String business_Number;
    private String business_Activity;
    private String role;

    public BusinessHelper(String name, String email, String password, String username, String tel_Number, String owner_ID, String fiscal_Number, String business_Number, String business_Activity, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
        this.tel_Number = tel_Number;
        this.owner_ID = owner_ID;
        this.fiscal_Number = fiscal_Number;
        this.business_Number = business_Number;
        this.business_Activity = business_Activity;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getTel_Number() {
        return tel_Number;
    }

    public String getOwner_ID() {
        return owner_ID;
    }

    public String getFiscal_Number() {
        return fiscal_Number;
    }

    public String getBusiness_Number() {
        return business_Number;
    }

    public String getBusiness_Activity() {
        return business_Activity;
    }

    public String getRole() {
        return role;
    }
}