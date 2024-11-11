// import com.ufund.api.model.*;
package com.ufund.api.model;

import java.util.logging.Logger;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Represents a Hero entity
 * 
 * @author Team Axiom
 */
public class Need {
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Need.class.getName());

    // Package private for tests
    static final String STRING_FORMAT = "Need/User [id=%d, name=%s]";

    @JsonProperty("id") private int id;
    @JsonProperty("name") private String name;
    @JsonProperty("quantity") private int quantity;

    /**
     * Create a need with the given id and name
     * @param id The id of the need
     * @param name The name of the need
     * 
     * {@literal @}JsonProperty is used in serialization and deserialization
     * of the JSON object to the Java object in mapping the fields.  If a field
     * is not provided in the JSON object, the Java field gets the default Java
     * value, i.e. 0 for int
     */
    public Need(@JsonProperty("name") String name, @JsonProperty("quantity") int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Retrieves the id of the need
     * @return The id of the need
     */
    public int getId() {return id;}

    /**
     * Sets the id of the need to new id
     * @param id of the need 
     */
    public void setId(int id) {this.id = id;}

    /**
     * Sets the name of the need - necessary for JSON object to Java object deserialization
     * @param name The name of the need
     */
    public void setName(String name) {this.name = name;}

    /**
     * Retrieves the name of the need
     * @return The name of the need
     */
    public String getName() {return name;}

        /**
     * Sets the quantity of the need - necessary for JSON object to Java object deserialization
     * @param quantity The quantity of the need
     */
    public void setQuantity(int quantity) {this.quantity = quantity;}

    /**
     * Retrieves the quantity of the need
     * @return The quantity of the need
     */
    public int getQuantity() {return quantity;}

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format(STRING_FORMAT,id,name);
    }
}
