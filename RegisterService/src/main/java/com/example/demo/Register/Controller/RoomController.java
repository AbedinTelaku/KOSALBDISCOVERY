package com.example.demo.Register.Controller;

import com.example.demo.Register.Helper.CreateRoomsHelper;
import com.example.demo.Register.Helper.RoomHelper;
import com.example.demo.Register.Models.Room;
import com.example.demo.Register.Service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/register/room")
public class RoomController {

    @Autowired
    private IRoomService iRoomService;

    public RoomController(IRoomService iRoomService) {
        this.iRoomService = iRoomService;
    }

    @PostMapping("/create/room/{businessUsername}")
    public void createRoom(@RequestBody RoomHelper roomHelper,@PathVariable("businessUsername") String businessUsername){
        this.iRoomService.createRoom(roomHelper.getRoomNumber(),roomHelper.getRoomType(),roomHelper.isAvailable(),roomHelper.getPrice(), roomHelper.getDiscount(),businessUsername);

    }
    @PostMapping("/create/rooms")
    public void createRooms(@RequestBody CreateRoomsHelper createRoomsHelper){
        this.iRoomService.createRooms(createRoomsHelper.getRooms());
    }
    @GetMapping("/get/room/{id}")
    public Room getRoomById(@PathVariable("id") int id){
        return this.iRoomService.getRoomById(id);
    }

    @GetMapping("/get/all/rooms")
    public List<Room> getAllRooms(){
        return this.iRoomService.getAllRooms();
    }

    @GetMapping("/get/all/rooms/{businessUsername}")
    public List<Room> getAllRoomsByBusinessId(@PathVariable("businessUsername") String businessUsername){
       return this.iRoomService.getAllRoomsByBusinessUsername(businessUsername);
    }

    @PostMapping("/delete/room/{id}")
    public void deleteRoomById(@PathVariable("id") int id){
        this.iRoomService.deleteRoomById(id);
    }

    @GetMapping("/get/roomtypes/{username}")
    public List<String> getRoomTypesByBusinessId(@PathVariable("username") String username){
        return this.iRoomService.getAllRoomTypesByBusinessId(username);
    }

    @GetMapping("/get/availableroom/{roomType}")
    public Room getAvailableRoom(@PathVariable("roomType") String roomType){
        return this.iRoomService.getFirstAvailableRoom(roomType);
    }

    @PostMapping("/set/room/unavailable/{roomNumber}")
    public void setReservedRoomUnavailable(@PathVariable("roomNumber") int roomNumber){
      this.iRoomService.setReservedRoomUnavailable(roomNumber);
    }

    @PostMapping("/set/room/available/{roomNumber}")
    public void setRoomAvailable(@PathVariable("roomNumber") int roomNumber){
         this.iRoomService.setRoomAvailable(roomNumber);
    }

    @GetMapping("/get/room/by/roomNumber/{roomNumber}")
    public Room getRoomsByRoomNumber(@PathVariable("roomNumber") int roomNumber){
       return this.iRoomService.getRoomByRoomNumber(roomNumber);
    }

    @GetMapping("/get/rooms/toshow/{businessUsername}")
    public List<Room> getRoomsToShow(@PathVariable("businessUsername") String businessUsername){
      return  this.iRoomService.getRoomsToShow(businessUsername);
    }
}
