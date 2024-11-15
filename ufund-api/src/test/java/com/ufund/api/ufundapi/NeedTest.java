package com.ufund.api.ufundapi;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.ufund.api.model.Need;

@Tag("Model-tier")
public class NeedTest {
    @Test
    public void testCtor() {
        int expected_quantity = 99;
        String expected_name = "DogFood";
        Need need = new Need(expected_name, expected_quantity);
        assertEquals(expected_quantity,need.getQuantity());
        assertEquals(expected_name,need.getName());
    }
    @Test
    public void testName() {
        // Setup
        int id = 99;
        String name = "Wi-Fire";
        Need need = new Need(name,id);

        String expected_name = "Galactic Agent";

        // Invoke
        need.setName(expected_name);

        // Analyze
        assertEquals(expected_name,need.getName());
    }

    @Test
    public void testGetNeed() {
        // Setup
        int id = 99;
        String name = "Wi-Fire";
        int quantity = 10;

       
        Need need = new Need(name,quantity);
        need.setId(id);

       assertEquals(id, need.getId());
       assertEquals(name, need.getName());
       assertEquals(quantity, need.getQuantity());
    
    }
    @Test
    public void testSetNeed() {
        // Setup
        Need need = new Need("Toys", 5);

       need.setId(42);
       need.setName("Ball");
       need.setQuantity(2);
      
       assertEquals(42, need.getId());
       assertEquals("Ball", need.getName());
       assertEquals(2, need.getQuantity());
    
    }
    @Test
    public void testToString() {
        // Setup
        int id = 99;
        String name = "Wi-Fire";
        int quantity = 10;

        String expectedString = String.format(Need.STRING_FORMAT,id,name);
       
        Need need = new Need(name,quantity);
        need.setId(id);

       assertEquals(expectedString, need.toString());
    
    }
    @Test
    public void testDefaultValue() {
        // Setup
        String name = "No need";
        Need need = new Need(name, 0);

        assertEquals(0, need.getId());
        assertEquals(name, need.getName());
        assertEquals(0, need.getQuantity());
    }
}


