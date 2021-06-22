package com.example.gatewayservice.Authentication.Core.Config;

import com.example.gatewayservice.Authentication.Application.InputPort.AuthenticateInputPort;
import com.example.gatewayservice.Authentication.Core.Domain.AuthenticationDomain;
import com.example.gatewayservice.Authentication.Core.Exception.AppException;
import com.example.gatewayservice.Authentication.Core.Helper.RequestHelper;
import com.example.gatewayservice.Authentication.Core.Helper.UserHelper;
import com.example.gatewayservice.Authentication.Core.OutputPort.AuthenticateOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    @Autowired
    private AuthenticationDomain authenticationDomain;

    @Autowired
    private AuthenticateOutputPort authenticateOutputPort;

    private final WebClient.Builder webClientBuilder;

    public AuthFilter(WebClient.Builder webClientBuilder) {
        super(Config.class);
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new RuntimeException("Missing authorization information");
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

            String[] parts = authHeader.split(" ");

            if (parts.length != 2 || !"Bearer".equals(parts[0])) {
                throw new RuntimeException("Incorrect authorization structure");
            }
            String token = parts[1];
            String username = authenticationDomain.getUsernameFromToken(token);
            UserHelper userHelper = this.authenticateOutputPort.getUserByUsername(username);

              if(authenticationDomain.validateToken(token,userHelper)){
                  //token is valid send request to services
                  //return webClientBuilder.build()
                       /*   .post()
                          .uri("http://localhost:9000/authenticate/validate" + parts[1])
                          .retrieve().bodyToMono(RequestHelper.class)
                          .map(requestHelper -> {
                              exchange.getRequest()
                                      .mutate()
                                      .header("auth-user-username", requestHelper.getUsername());
                              return exchange;
                          }).flatMap(chain::filter); */

              }else{
                  throw new AppException("Token is invalid", HttpStatus.BAD_REQUEST);
              }

        };
    }

    public static class Config {
        // empty class as I don't need any particular configuration
    }
}
