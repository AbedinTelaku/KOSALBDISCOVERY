package com.example.demo.Register.Service;

import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Models.Room;

import java.util.List;

public interface IRoomService {
    void createRoom(int roomNumber, String roomType, boolean isAvailable,double price, double discount ,String businessUsername);
    void createRooms(List<Room> rooms);
    Room getRoomById(int id);
    List<Room> getAllRooms();
    void deleteRoomById(int id);
    void editRoom(int id,int roomNumber, String roomType, boolean isAvailable, Business business);

}
