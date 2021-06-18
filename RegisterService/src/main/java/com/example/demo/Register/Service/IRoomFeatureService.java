package com.example.demo.Register.Service;

import com.example.demo.Register.Models.RoomFeature;

import java.util.List;

public interface IRoomFeatureService {

    void createRoomFeature(String feature, int roomId);
    void deleteRoomFeature(int id);
    RoomFeature getRoomFeature(int id);
    List<RoomFeature> getAllRoomFeaturesByRoomId(int roomId);
}
