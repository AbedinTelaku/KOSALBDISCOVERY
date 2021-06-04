package com.example.demo.Register.Service;

import com.example.demo.Register.Models.City;
import com.example.demo.Register.Models.TouristPlace;
import com.example.demo.Register.Repository.TouristPlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristPlaceService implements ITouristPlaceService{
    private TouristPlaceRepository touristPlaceRepository;

    public TouristPlaceService(TouristPlaceRepository touristPlaceRepository) {
        this.touristPlaceRepository = touristPlaceRepository;
    }

    @Override
    public void createTouristPlace(String name, City city) {
        TouristPlace touristPlace = new TouristPlace(name,city);
        this.touristPlaceRepository.save(touristPlace);
    }

    @Override
    public void deleteTouristPlace(int id) {
        this.touristPlaceRepository.deleteById(id);

    }

    @Override
    public TouristPlace getToruistPlace(int id) {
        Optional<TouristPlace> touristPlaceOptional = this.touristPlaceRepository.findById(id);

        return touristPlaceOptional.get();
    }

    @Override
    public List<TouristPlace> getAllTouristPlaces() {
        return this.touristPlaceRepository.findAll();
    }

    @Override
    public List<String> getAllTouristPlacesNames() {
        return this.touristPlaceRepository.getTouristPlacesNames();
    }
}
