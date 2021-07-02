package com.example.demo.Register.Service;

import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Models.Room;

import java.util.List;

public interface IRoomService {
    void createRoom(int roomNumber, String roomType, boolean isAvailable,double price, double discount ,String businessUsername);
    void createRooms(List<Room> rooms);
    void createRoomWithNumberAndType(String roomType, int roomNumber,String username);
    Room getRoomById(int id);
    List<Room> getAllRooms();
    List<Room> getAllRoomsByBusinessUsername(String businessUsername);
    List<Room> getRoomsToShow(String businessUsername);
    void deleteRoomById(int id);
    void editRoom(int id,int roomNumber, String roomType, boolean isAvailable, Business business);
    List<String> getAllRoomTypesByBusinessId(String username);
    Room getFirstAvailableRoom(String roomType);
    void setReservedRoomUnavailable(int roomNumber);
    void setRoomAvailable(int roomNumber);
    Room getRoomByRoomNumber(int roomNumber);


}
