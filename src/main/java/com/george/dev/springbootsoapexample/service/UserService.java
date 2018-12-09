package com.george.dev.springbootsoapexample.service;

import com.george.dev.springbootsoapexample.wsdl.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by George on 09/12/2018
 */

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initializeData(){
        User user1 = new User();
        user1.setName("George");
        user1.setEmpId(001);
        user1.setSalary(200000.00);
        users.put(user1.getName(), user1);

        User user2 = new User();
        user2.setName("Tony");
        user2.setEmpId(002);
        user2.setSalary(200000.00);
        users.put(user2.getName(), user2);

        User user3 = new User();
        user3.setName("Tom");
        user3.setEmpId(003);
        user3.setSalary(200000.00);
        users.put(user3.getName(), user3);
    }

    public User getUser(String username){
        return users.get(username);
    }
}
