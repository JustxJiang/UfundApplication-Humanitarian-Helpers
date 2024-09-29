package com.ufund.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ufund.api.persistence.CupboardDAO;
import com.ufund.api.model.Need;

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
        LOG.info("GET /Needes/?name="+name);

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
        
}
