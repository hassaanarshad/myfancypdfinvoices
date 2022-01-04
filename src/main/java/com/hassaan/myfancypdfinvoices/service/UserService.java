package com.hassaan.myfancypdfinvoices.service;

import java.util.UUID;

import com.hassaan.myfancypdfinvoices.model.User;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    
    public User findById(String id) {
        String randomName = UUID.randomUUID().toString();

        return new User(id, randomName);
    }
}
