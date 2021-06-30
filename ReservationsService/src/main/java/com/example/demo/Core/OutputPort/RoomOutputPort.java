package com.example.demo.Core.OutputPort;

import com.example.demo.Core.Helper.RoomHelper;


public interface RoomOutputPort {

    RoomHelper getAvailableRoom();
    RoomHelper getRoomByRoomNumber(int roomNumber);
    void setReservedRoomUnavailable(int roomNumber);
    void setRoomAvailable(int roomNumber);
}
