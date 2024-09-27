package com.ufund.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ufund.api.persistence.UserDAO;
import com.ufund.api.model.User;

public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());

    @PostMapping("")
    public ResponseEntity<User> createHero(@RequestBody User user) {
        LOG.info("POST /users " + user);

        // Replace below with your implementation
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/")
    public ResponseEntity<Hero[]> searchHeroes(@RequestParam String name) {
        LOG.info("GET /heroes/?name="+name);

        try {

            User[] userArray = userDao.getUsers();
            ArrayList<User> foundList = new ArrayList<>();

            for (int i = 0; i < userArray.length; i++) {
                
                if (userArray[i].getName().indexOf(name) != -1) {
                    foundList.add(userArray[i]);
                }

            }

            User[] foundArray = new User[foundList.size()];
            foundList.toArray(foundArray);

            return new ResponseEntity<>(foundArray, HttpStatus.OK);

        }

        catch (Exception e) {
            LOG.log(Level.SEVERE,e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
        
}
