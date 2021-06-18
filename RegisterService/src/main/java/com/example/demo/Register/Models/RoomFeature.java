package com.example.demo.Register.Models;

import javax.persistence.*;

@Entity
public class RoomFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String feature;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Room room;

    public RoomFeature(String feature, Room room) {
        this.feature = feature;
        this.room = room;
    }

    public RoomFeature() {
    }

    public int getId() {
        return id;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
