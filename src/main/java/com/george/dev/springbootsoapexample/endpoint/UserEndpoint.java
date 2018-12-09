package com.george.dev.springbootsoapexample.endpoint;

import com.george.dev.springbootsoapexample.service.UserService;
import com.george.dev.springbootsoapexample.wsdl.GetUserRequest;
import com.george.dev.springbootsoapexample.wsdl.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by George on 09/12/2018
 */

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://springbootsoapexample.dev.george.com/wsdl";

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserResponse(@RequestPayload GetUserRequest request){
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUser(request.getName()));

        return response;
    }
}
