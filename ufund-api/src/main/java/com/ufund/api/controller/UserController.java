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
    private CupboardDAO needDao;

    public UserController(CupboardDAO needDao) {
        this.needDao = needDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Need> getNeed(@PathVariable int id) {

        LOG.info("GET /needs/" + id);
        try {
            Need need = needDao.getNeed(id);
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
                Need need = needDao.getNeed(needCount);
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

            Need[] NeedArray = needDao.getNeeds();
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

    
    @PostMapping("")
    public ResponseEntity<Need> createNeed(@RequestBody Need need) {
        LOG.info("POST /needs " + need);

        try {

            if (need != null) {
                Need createdNeed = needDao.createNeed(need);
                
                if(createdNeed == null){
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                }
                return new ResponseEntity<>(HttpStatus.CREATED);

            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);

           

            

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

    @PutMapping("")
    public ResponseEntity<Need> updateNeed(@RequestBody Need need) {
        LOG.info("PUT /needs " + need);
        try {

            if (need != null) {
                Need updatedNeed =needDao.updateNeed(need);

                return new ResponseEntity<>(updatedNeed,HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            

        }

        catch (Exception e) {
            LOG.log(Level.SEVERE,e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Need[]> deleteNeed(@PathVariable int id) {
        LOG.info("DELETE /needs/" + id);
        try {
            Need[] needarray = needDao.getNeeds();
            for(int i = 0; i < needarray.length; i++){
                if(needarray[i].getId() == id){
                    needDao.deleteNeed(id);
                    return new ResponseEntity<>(HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
                    LOG.log(Level.SEVERE, e.getLocalizedMessage());
                }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


