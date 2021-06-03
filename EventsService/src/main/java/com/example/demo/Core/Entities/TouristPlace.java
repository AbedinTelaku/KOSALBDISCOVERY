package com.example.demo.Core.Entities;

import javax.persistence.Embeddable;

@Embeddable
public class TouristPlace {

    private String touristPlaceName;

    public String getTouristPlaceName() {
        return touristPlaceName;
    }

    public void setTouristPlaceName(String touristPlaceName) {
        this.touristPlaceName = touristPlaceName;
    }
}
