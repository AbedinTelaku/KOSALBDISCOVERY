package com.example.demo.Infrastructure.OutputAdapter;

import com.example.demo.Core.Helper.UserHelper;
import com.example.demo.Core.OutputPort.UserOutputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserOutputAdapter implements UserOutputPort {
    @Override
    public String getUserFullNameByUsername(String username) {

        RestTemplate restTemplate =new RestTemplate();
        String registerServiceURL = "http://localhost:8080/api/user/get/user/"+username;
        ResponseEntity<UserHelper> responseEntity = restTemplate.getForEntity(registerServiceURL,UserHelper.class);

        String name = responseEntity.getBody().getName();
        String surname  =responseEntity.getBody().getSurname();
        String fullName = name;

        if(surname != null){
            fullName+=" " + surname;
        }

        return fullName;
    }
}
