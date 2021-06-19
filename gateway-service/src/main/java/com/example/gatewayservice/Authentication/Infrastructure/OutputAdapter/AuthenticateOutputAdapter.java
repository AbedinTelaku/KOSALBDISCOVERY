package com.example.gatewayservice.Authentication.Infrastructure.OutputAdapter;


import com.example.gatewayservice.Authentication.Core.OutputPort.AuthenticateOutputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticateOutputAdapter implements AuthenticateOutputPort {
    @Override
    public boolean userExist(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();
        String userURL = "http://localhost:8080/api/register/user/check/user/"+username+"/"+password;
        ResponseEntity<Boolean> doesExist = restTemplate.getForEntity(userURL, Boolean.class);

        return doesExist.getBody();
    }
}
