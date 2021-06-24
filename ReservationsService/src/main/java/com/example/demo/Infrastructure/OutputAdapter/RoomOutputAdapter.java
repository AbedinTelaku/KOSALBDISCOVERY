package com.example.demo.Infrastructure.OutputAdapter;

import com.example.demo.Core.Helper.RoomHelper;
import com.example.demo.Core.OutputPort.RoomOutputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RoomOutputAdapter implements RoomOutputPort {

    @Override
    public RoomHelper getRoomByID(int id) {
        RestTemplate restTemplate=new RestTemplate();
        String registerServiceURL = "http://localhost:8080/api/register/room/get/room/"+id;
        ResponseEntity<RoomHelper> responseEntity = restTemplate.getForEntity(registerServiceURL,RoomHelper.class);

        RoomHelper roomHelper= responseEntity.getBody();

        return roomHelper;
    }
}
