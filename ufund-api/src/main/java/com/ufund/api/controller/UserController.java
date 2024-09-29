package com.ufund.api.controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufund.api.model.Need;
import com.ufund.api.persistence.CupboardDAO;

public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    private CupboardDAO NeedDao;

    /* Create Need (CRUD) */
    @PostMapping("")
    public ResponseEntity<Need> createNeed(@RequestBody Need Need) {
        LOG.info("POST /Needs " + Need);

        // Replace below with your implementation
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/")
    public ResponseEntity<Need[]> searchNeeds(@RequestParam String name) {
        LOG.info("GET /Needs/?name="+name);

        try {

            Need[] NeedArray = NeedDao.getNeeds();
            ArrayList<Need> foundList = new ArrayList<>();

            for (int i = 0; i < NeedArray.length; i++) {
                
                if (NeedArray[i].getName().indexOf(name) != -1) {
                    foundList.add(NeedArray[i]);
                }
            }

            Need[] foundArray = new Need[foundList.size()];
            foundList.toArray(foundArray);

            return new ResponseEntity<>(foundArray, HttpStatus.OK);

        }

        catch (Exception e) {
            LOG.log(Level.SEVERE,e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    public ResponseEntity<Need[]> setNeeds(@RequestParam String name, @RequestParam String newName) {
        LOG.info("SET /Needs/?name="+name+"/?newName="+newName);
        try {
            Need[] NeedArray = NeedDao.getNeeds();
            Need SettingNeed;
            for (int i = 0; i < NeedArray.length; i++) {
                if (NeedArray[i].getName() == name) {
                    SettingNeed = NeedArray[i];
                    SettingNeed.setName(newName);
                    NeedDao.updateNeed(NeedArray[i], SettingNeed);
                }
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOG.log(Level.SEVERE,e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
}
