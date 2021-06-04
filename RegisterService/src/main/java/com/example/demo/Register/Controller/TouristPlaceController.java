package com.example.demo.Register.Controller;

import com.example.demo.Register.Models.TouristPlace;
import com.example.demo.Register.Service.ITouristPlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/touristPlace")
public class TouristPlaceController {
    private ITouristPlaceService iTouristPlaceService;

    public TouristPlaceController(ITouristPlaceService iTouristPlaceService) {
        this.iTouristPlaceService = iTouristPlaceService;
    }

    @GetMapping("/get//{id}")
    public TouristPlace getTouristPlace(@PathVariable("id") int id){
        return this.iTouristPlaceService.getToruistPlace(id);
    }

    @GetMapping("get/all")
    public List<TouristPlace> getAllTouristplaces(){
        return this.iTouristPlaceService.getAllTouristPlaces();
    }

    @GetMapping("get/all/names/{cityName}")
    public List<String> getAllTouristplacesNames(@PathVariable("cityName") String cityName){
        return this.iTouristPlaceService.getAllTouristPlacesNames();
    }
}
