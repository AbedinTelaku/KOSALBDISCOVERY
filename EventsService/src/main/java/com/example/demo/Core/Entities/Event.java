package com.example.demo.Core.Entities;

import javax.persistence.*;
import java.sql.Date;

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private String status;
    @Embedded
    private User user;
    @Embedded
    private City city;
    @Embedded
    private TouristPlace touristPlace;

    public Event(String name, String description,Date startDate, Date endDate, String status,User user, City city, TouristPlace touristPlace){
        this.name=name;
        this.description=description;
        this.startDate=startDate;
        this.endDate=endDate;
        this.status=status;
        this.user=user;
        this.city = city;
        this.touristPlace=touristPlace;
    }
    public Event(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public TouristPlace getTouristPlace() {
        return touristPlace;
    }

    public void setTouristPlace(TouristPlace touristPlace) {
        this.touristPlace = touristPlace;
    }
}
