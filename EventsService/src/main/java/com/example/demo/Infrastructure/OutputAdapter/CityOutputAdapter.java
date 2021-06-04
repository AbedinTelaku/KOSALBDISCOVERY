package com.example.demo.Infrastructure.OutputAdapter;

import com.example.demo.Core.Entities.City;
import com.example.demo.Core.Helper.CityHelper;
import com.example.demo.Core.OutputPort.CityOutputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class CityOutputAdapter implements CityOutputPort {
    @Override
    public List<String> getAllCitiesNames() {
        RestTemplate restTemplate = new RestTemplate();
        String registerServiceUrl = "http://localhost:8080/api/city/get/all/names";
        ResponseEntity<CityHelper> responseEntity = restTemplate.getForEntity(registerServiceUrl,CityHelper.class);
        List<String> cityHelperList = responseEntity.getBody().getCitiesNames();
        return cityHelperList;
    }
}
