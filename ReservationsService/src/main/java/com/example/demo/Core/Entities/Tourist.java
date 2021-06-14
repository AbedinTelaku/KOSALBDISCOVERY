package com.example.demo.Core.Entities;

import javax.persistence.Embeddable;

@Embeddable
public class Tourist {
    private String touristName;
    private String touristEmail;

    public Tourist(String touristName, String touristEmail) {
        this.touristName = touristName;
        this.touristEmail = touristEmail;
    }

    public Tourist() {
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public String getTouristEmail() {
        return touristEmail;
    }

    public void setTouristEmail(String touristEmail) {
        this.touristEmail = touristEmail;
    }
}
