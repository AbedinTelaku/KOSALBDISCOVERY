package com.example.demo.Register.Service;

import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Models.Room;
import com.example.demo.Register.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private IBusinessService iBusinessService;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void createRoom(int roomNumber, String roomType, boolean isAvailable, String businessUsername) {
        Business business = this.iBusinessService.getBusinessByUsername(businessUsername);
       Room room = new Room(roomNumber,roomType,isAvailable,business);
        this.roomRepository.save(room);
    }

    @Override
    public void createRooms(List<Room> rooms) {
        this.roomRepository.saveAll(rooms);
    }

    @Override
    public Room getRoomById(int id) {
        Optional<Room> roomOptional = this.roomRepository.findById(id);
        return roomOptional.get();
    }

    @Override
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    @Override
    public void deleteRoomById(int id) {
      this.roomRepository.deleteById(id);
    }

    @Override
    public void editRoom(int id, int roomNumber, String roomType, boolean isAvailable, Business business) {

    }
}
