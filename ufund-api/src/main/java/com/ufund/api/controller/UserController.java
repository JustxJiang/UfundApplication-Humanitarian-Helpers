package com.ufund.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufund.api.model.Need;
import com.ufund.api.persistence.CupboardDAO;

public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    private CupboardDAO NeedDao;

    @PostMapping("")
    public ResponseEntity<Need> createHero(@RequestBody Need need) {
        LOG.info("POST /needs " + need);

        try {

            if (need != null) {
                NeedDao.createNeed(need);
            }

            return new ResponseEntity<>(HttpStatus.OK);

        }

        catch (Exception e) {
            LOG.log(Level.SEVERE,e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
        @GetMapping("/{id}")
        public ResponseEntity<Need> getNeed(@PathVariable int id) {
        LOG.info("GET /heroes/" + id);
        try {
            Need need = NeedDao.getNeed(id);
            if (need != null){

                return new ResponseEntity<Need>(need,HttpStatus.OK);
            }    
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
               
        }
        catch(IOException e) {
            LOG.log(Level.SEVERE,e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // public ResponseEntity<Need[]> setNeeds(@RequestParam String name, @RequestParam String newName) {
    //     LOG.info("SET /Needs/?name="+name+"/?newName="+newName);
    //     try {
    //         Need[] NeedArray = NeedDao.getNeeds();
    //         Need SettingNeed;
    //         for (int i = 0; i < NeedArray.length; i++) {
    //             if (NeedArray[i].getName() == name) {
    //                 SettingNeed = NeedArray[i];
    //                 SettingNeed.setName(newName);
    //                 NeedDao.updateNeed(NeedArray[i], SettingNeed);
    //             }
    //         }
    //         return new ResponseEntity<>(HttpStatus.OK);
    //     } catch (Exception e) {
    //         LOG.log(Level.SEVERE,e.getLocalizedMessage());
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @PutMapping("")
    public ResponseEntity<Need> updateHero(@RequestBody Need need) {
        LOG.info("PUT /needs " + need);
        try {

            if (need != null) {
                NeedDao.updateNeed(need);
            }

            return new ResponseEntity<>(HttpStatus.OK);

        }

        catch (Exception e) {
            LOG.log(Level.SEVERE,e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Need[]> deleteNeed(@RequestParam int id, @RequestParam String name) {
        LOG.info("DELETE /Needs/?name=" + name + "/?id"+ id);
        try {
            boolean deleted = NeedDao.deleteNeed(id);
            if(deleted)
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
}