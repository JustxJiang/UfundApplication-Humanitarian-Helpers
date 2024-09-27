package com.ufund.api.model;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
    private static final Logger LOG = Logger.getLogger(User.class.getName());
    
    @JsonProperty("id") private int id; 
    @JsonProperty("name") private String name; 
    
}
