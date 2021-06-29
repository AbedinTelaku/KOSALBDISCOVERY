package com.example.demo.Infrastructure.OutputAdapter;

import com.example.demo.Core.Helper.UserHelper;
import com.example.demo.Core.OutputPort.NotificationOutputPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Email;

@Service
public class NotificationOutputAdapter implements NotificationOutputPort {
    @Override
    public void sendEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(email);

        String reservationServiceURL = "http://localhost:8001/api/email/message/"+email;
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(reservationServiceURL,request,String.class);


    }
}
