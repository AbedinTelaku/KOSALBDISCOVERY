package com.example.demo.Application.InputAdapter;
import com.example.demo.Application.InputPort.EventInputport;
import com.example.demo.Core.Entities.Event;
import com.example.demo.Core.Helper.EventHelper;
import com.example.demo.Core.Helper.EventStatusHelper;
import com.example.demo.Core.OutputPort.UserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/register/event")
public class EventController {

    @Autowired
    private EventInputport eventInputport;

    @Autowired
    private UserOutputPort userOutputPort;

   public EventController(EventInputport eventInputport) {
        this.eventInputport = eventInputport;

    }

    @PostMapping("/create")
    public void createEvent(@RequestBody EventHelper eventHelper){
       this.eventInputport.createEvent(eventHelper.getName(),eventHelper.getDescription(),eventHelper.getStartDate(),eventHelper.getEndDate(),eventHelper.getStartTime(),eventHelper.getPhotoPath(),eventHelper.getCityName(),eventHelper.getTouristPlaceName(),eventHelper.getUsername());
    }
    @GetMapping("/get/all/events")
    public List<Event> getAllEvents(){
        return this.eventInputport.getAllEvents();
    }

    @GetMapping("/get/events/status")
    public List<Event> getEventStatus(@RequestBody EventStatusHelper eventStatusHelper){
       return this.eventInputport.getEventStatus(eventStatusHelper.getStatus());
    }

    @GetMapping("/get/event/creator/{username}")
    public String getEventCreator(@PathVariable("username") String username){

       return this.userOutputPort.getUserFullNameByUsername(username);
    }
}
