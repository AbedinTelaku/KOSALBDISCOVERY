package com.example.demo.Register.Controller;

import com.example.demo.Register.Helper.RoomFeatureHelper;
import com.example.demo.Register.Models.RoomFeature;
import com.example.demo.Register.Service.IRoomFeatureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/register/roomFeature")
public class RoomFeatureController {
    private IRoomFeatureService iRoomFeatureService;

    public RoomFeatureController(IRoomFeatureService iRoomFeatureService) {
        this.iRoomFeatureService = iRoomFeatureService;
    }

    @PostMapping("/create")
    public void createRoomFeature(@RequestBody RoomFeatureHelper roomFeatureHelper){
        this.iRoomFeatureService.createRoomFeature(roomFeatureHelper.getFeature(),roomFeatureHelper.getRoomId());
    }

    @GetMapping("/get/all/{roomId}")
    public List<RoomFeature> getAllByRoomId(@PathVariable("roomId") int roomId){
        return this.iRoomFeatureService.getAllRoomFeaturesByRoomId(roomId);
    }
}
