package com.example.demo.Core.Domain;

import com.example.demo.Core.Entities.City;
import com.example.demo.Core.Entities.Event;
import com.example.demo.Core.Entities.TouristPlace;
import com.example.demo.Core.Entities.User;
import com.example.demo.Core.OutputPort.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Time;

public class EventDomain {

    @Autowired
    private EventRepository eventRepository;

    public EventDomain(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(String name, String description, Date startDate, Date endDate, Time startTime, User user, City city, TouristPlace touristPlace){

       String status = setEventStatus(startDate,endDate);

       Event event = new Event(name,description,startDate,endDate,startTime,status,user,city,touristPlace);

       this.eventRepository.save(event);
    }

    // check start and end date to figure the event status

    public String setEventStatus(Date startDate,Date endDate){
        Date currentDate = new Date(System.currentTimeMillis());

        if(endDate.before(currentDate)){
            return "finished";
        }if(startDate.after(currentDate)){
            return "starting";
        }else{
            return "happening";
        }

    }

    public void updateEvent(){

        //editEvent();
    }
}
