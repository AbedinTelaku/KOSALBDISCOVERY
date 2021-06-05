package com.example.demo.Core.Helper;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class EventHelper implements Serializable {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private String cityName;
    private String touristPlaceName;
    private String username;

    public EventHelper(String name, String description, Date startDate, Date endDate,Time startTime ,String cityName, String touristPlaceName, String username) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime=startTime;
        this.cityName = cityName;
        this.touristPlaceName = touristPlaceName;
        this.username=username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTouristPlaceName() {
        return touristPlaceName;
    }

    public void setTouristPlaceName(String touristPlaceName) {
        this.touristPlaceName = touristPlaceName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
}
