package com.example.demo.Register.Service;

import com.example.demo.Register.Models.City;
import com.example.demo.Register.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService{

    @Autowired
    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void createCity(String name, String zipCode) {
        City city = new City(name,zipCode);
        this.cityRepository.save(city);
    }

    @Override
    public void deleteCity(int id) {
        Optional<City> cityOptional = this.cityRepository.findById(id);

        this.cityRepository.delete(cityOptional.get());

    }

    @Override
    public City getCity(String name) {
        return null;
    }

    @Override
    public City getCity(int id) {
        Optional<City> cityOptional= this.cityRepository.findById(id);
        return cityOptional.get();
    }

    @Override
    public List<City> getAllCities() {

        return this.cityRepository.findAll();
    }

    @Override
    public List<String> getAllCitiesNames() {
        return this.cityRepository.getCitiesNames();
    }
}
