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
        Need hero = new Need(expected_name, expected_quantity);
        assertEquals(expected_quantity,hero.getQuantity());
        assertEquals(expected_name,hero.getName());
    }
}