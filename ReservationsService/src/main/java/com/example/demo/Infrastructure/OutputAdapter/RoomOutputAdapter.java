package com.example.demo.Infrastructure.OutputAdapter;

import com.example.demo.Core.Helper.RoomHelper;
import com.example.demo.Core.OutputPort.RoomOutputPort;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RoomOutputAdapter implements RoomOutputPort {

    @Override
    public RoomHelper getAvailableRoom(String type) {
        RestTemplate restTemplate=new RestTemplate();
        String registerServiceURL = "http://localhost:8080/api/register/room/get/availableroom/"+type;
        ResponseEntity<RoomHelper> responseEntity = restTemplate.getForEntity(registerServiceURL,RoomHelper.class);

        if(responseEntity.getBody() != null){
            return responseEntity.getBody();
        }else{
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }



    }

    @Override
    public RoomHelper getRoomByRoomNumber(int roomNumber) {
        RestTemplate restTemplate=new RestTemplate();
        String registerServiceURL = "http://localhost:8080/api/register/room/get/room/by/roomNumber/"+roomNumber;
        ResponseEntity<RoomHelper> responseEntity = restTemplate.getForEntity(registerServiceURL,RoomHelper.class);

        if(responseEntity.getBody() != null){
            return responseEntity.getBody();
        }else{
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void setReservedRoomUnavailable(int roomNumber) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Integer> request = new HttpEntity<Integer>(roomNumber);

        String reservationServiceURL = "http://localhost:8080/api/register/room/set/room/unavailable/"+roomNumber;
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity(reservationServiceURL,request,Void.class);

    }

    @Override
    public void setRoomAvailable(int roomNumber) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Integer> request = new HttpEntity<Integer>(roomNumber);

        String reservationServiceURL = "http://localhost:8080/api/register/room/set/room/available/"+roomNumber;
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity(reservationServiceURL,request,Void.class);
    }
}
