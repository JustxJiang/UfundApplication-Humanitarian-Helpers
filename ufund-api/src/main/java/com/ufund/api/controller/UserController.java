package com.ufund.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.logging.Logger;
import com.ufund.api.model.User;

public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());

    @PostMapping("")
    public ResponseEntity<User> createHero(@RequestBody User user) {
        LOG.info("POST /users " + user);

        // Replace below with your implementation
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
        
}
