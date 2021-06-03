package com.example.demo.Application.InputAdapter;
import com.example.demo.Application.InputPort.EventInputport;
import com.example.demo.Core.Entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/event")
public class EventController {

    @Autowired
    private EventInputport eventInputport;


   public EventController(EventInputport eventInputport) {
        this.eventInputport = eventInputport;

    }

    public EventController() {
    }

    @GetMapping("/get/all/events")
    public List<Event> getAllEvents(){
        return this.eventInputport.getAllEvents();
    }


    @PostMapping("/get/event/creator/{username}")
    public String getEventCreator(@PathVariable("username") String username){
        return null;
    }
}
