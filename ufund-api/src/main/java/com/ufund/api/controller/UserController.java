package com.ufund.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());

    @PostMapping("")
    public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
        LOG.info("POST /heroes " + hero);

        // Replace below with your implementation
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
        
}
