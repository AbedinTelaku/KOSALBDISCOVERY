package com.example.demo.Register.Helper;

import java.io.Serializable;

public class RoomFeatureHelper implements Serializable {
    private String feature;
    private int roomId;

    public RoomFeatureHelper(String feature, int roomId) {
        this.feature = feature;
        this.roomId = roomId;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
