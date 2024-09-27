package com.ufund.api.model;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
    private static final Logger LOG = Logger.getLogger(User.class.getName());
    static final String STRING_FORMAT = "Hero [id=%d, name=%s]";
        
    @JsonProperty("id") private int id; 
    @JsonProperty("name") private String name; 

    /**
     * Create a user with the given id and name
     * @param id The id of the user
     * @param name The name of the user
     * 
     */
    public User(@JsonProperty("id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Retrieves  id of the user
     * @return The id of the user
     */
    public int getId() {return id;}

    /**
     * Sets the name of the user
     * @param name The name of the user
     */
    public void setName(String name) {this.name = name;}

    /**
     * Retrieves the name of the user
     * @return The name of the user
     */
    public String getName() {return name;}

    @Override
    public String toString() {
        return String.format(STRING_FORMAT,id,name);
    }
}
