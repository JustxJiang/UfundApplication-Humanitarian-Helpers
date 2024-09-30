package com.ufund.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.catalina.connector.Response;
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

import com.ufund.api.model.Need;
import com.ufund.api.persistence.CupboardDAO;


@RestController
@RequestMapping("needs")
public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    private CupboardDAO NeedDao;

    public UserController(CupboardDAO NeedDao) {
        this.NeedDao = NeedDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Need> getNeed(@PathVariable int id) {

        LOG.info("GET /needs/" + id);
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

    @GetMapping("")
    public ResponseEntity<Need[]> getNeeds(){
        LOG.info("GET /needs");

        try {
            
            ArrayList<Need> needList = new ArrayList<>();

            // Hardcoded, ideally should check for min id
            for (int needCount = 1; ; needCount++) {
                Need need = NeedDao.getNeed(needCount);
                if (need == null) {
                    break;
                }
                needList.add(need);
            }

            Need[] needArray = new Need[needList.size()];
            needList.toArray(needArray);

            return new ResponseEntity<Need[]>(needArray, HttpStatus.OK);
            
        }
        catch (Exception e) {
            LOG.log(Level.SEVERE,e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Need[]> searchNeeds(@RequestParam String name) {
        LOG.info("GET /needs/?name="+name);

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
<<<<<<< HEAD

    @PostMapping("")
    public ResponseEntity<Need> createHero(@RequestBody Need need) {
        LOG.info("POST /needs " + need);

        try {

            if (need != null) {
                NeedDao.createNeed(need);
=======
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
>>>>>>> 6658f90d65651c8e5d813df1bfdacef92b91746d
            }

            return new ResponseEntity<>(HttpStatus.OK);

        }

        catch (Exception e) {
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

    public ResponseEntity<Need> findNeeds(String containsText) {
        return null;
    }

    @PutMapping("")
    public ResponseEntity<Need> updateNeed(@RequestBody Need need) {
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
    public ResponseEntity<Need[]> deleteNeed(@PathVariable int id) {
        LOG.info("DELETE /Needs/" + id);
        try{
            Need need = NeedDao.getNeed(id);
            if(need != null){
                boolean deleted = NeedDao.deleteNeed(id);
                if(deleted){
                    return new ResponseEntity<>(HttpStatus.OK);
                }else{
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
        } catch (Exception e) {
                    LOG.log(Level.SEVERE, e.getLocalizedMessage());
                }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
<<<<<<< HEAD
    }
=======
    
    @GetMapping("")
    public ResponseEntity<Need[]> getNeeds(){
        LOG.info("GET /needs");
        try {
            Need[] needs = NeedDao.getNeeds();
            if(needs.length > 0){
                return new ResponseEntity<>(needs, HttpStatus.OK);
                
            }else{ // getNeeds returned an array of 0 needs
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
>>>>>>> 6658f90d65651c8e5d813df1bfdacef92b91746d


}
