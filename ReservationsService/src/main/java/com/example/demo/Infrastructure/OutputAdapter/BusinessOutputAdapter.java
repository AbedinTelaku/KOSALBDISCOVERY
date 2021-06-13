package com.example.demo.Infrastructure.OutputAdapter;

import com.example.demo.Core.Helper.BusinessHelper;
import com.example.demo.Core.OutputPort.BusinessOutputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BusinessOutputAdapter implements BusinessOutputPort {

    @Override
    public BusinessHelper getBusinessByID(int id) {
        RestTemplate restTemplate=new RestTemplate();
        String registerServiceURL = "http://localhost:8080/api/business/get/business/"+id;
        ResponseEntity<BusinessHelper> responseEntity = restTemplate.getForEntity(registerServiceURL,BusinessHelper.class);

        BusinessHelper businessHelper= responseEntity.getBody();

        return businessHelper;
    }
}
