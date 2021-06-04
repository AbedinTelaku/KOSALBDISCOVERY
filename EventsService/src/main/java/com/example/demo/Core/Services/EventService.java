package com.example.demo.Core.Services;

import com.example.demo.Application.InputPort.EventInputport;
import com.example.demo.Core.Domain.EventDomain;
import com.example.demo.Core.Entities.City;
import com.example.demo.Core.Entities.Event;
import com.example.demo.Core.Entities.TouristPlace;
import com.example.demo.Core.Entities.User;
import com.example.demo.Core.OutputPort.EventRepository;
import com.example.demo.Core.OutputPort.UserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventInputport {

@Autowired
private EventRepository eventRepository;
@Autowired
private UserOutputPort userOutputPort;

private EventDomain eventDomain;

    public EventService(EventRepository eventRepository, UserOutputPort userOutputPort) {
        this.eventRepository = eventRepository;
        this.userOutputPort = userOutputPort;
    }

    public EventService() {
    }

    @Override
    public void createEvent(String name, String description, Date startDate,Date endDate,String cityName,String touristPlaceName,String username) {
        String userFullName = this.userOutputPort.getUserFullNameByUsername(username);
        //get city from register module
        //get tourist place from register module
        User user = new User(userFullName);
        City city = new City(cityName);
        TouristPlace touristPlace = new TouristPlace(touristPlaceName);

        eventDomain.createEvent(name,description,startDate,endDate,user,city,touristPlace);

    }

    @Override
    public void deleteEventById(int id) {
        this.eventRepository.deleteById(id);

    }

    @Override
    public Event getEventById(int id) {
       Optional<Event> eventOptional= this.eventRepository.findById(id);
       return eventOptional.get();
    }

    @Override
    public List<Event> getAllEvents() {
        return this.eventRepository.findAll();
    }
}
