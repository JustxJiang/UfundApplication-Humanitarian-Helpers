package com.ufund.api.ufundapi;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufund.api.model.Need;
import com.ufund.api.persistence.CupboardFileDao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Test the NeedFile DAO class
 * 
 * @author SWEN Faculty
 */
@Tag("Persistence-tier")
public class CupboardFileDaoTest {
    CupboardFileDao cupboardFileDAO;
    Need[] testNeeds;
    ObjectMapper mockObjectMapper;

    /**
     * Before each test, we will create and inject a Mock Object Mapper to
     * isolate the tests from the underlying file
     * @throws IOException
     */
    @BeforeEach
    public void setupCupboardFileDAO() throws IOException {
        mockObjectMapper = mock(ObjectMapper.class);
        testNeeds = new Need[3];
        testNeeds[0] = new Need("Wi-Fire",99);
        testNeeds[1] = new Need("Galactic Agent",100);
        testNeeds[2] = new Need("Ice Gladiator",101);
        testNeeds[0].setId(0);
        testNeeds[1].setId(1);
        testNeeds[2].setId(2);
        // When the object mapper is supposed to read from the file
        // the mock object mapper will return the hero array above
        when(mockObjectMapper
            .readValue(new File("doesnt_matter.txt"),Need[].class))
                .thenReturn(testNeeds);
        cupboardFileDAO = new CupboardFileDao("doesnt_matter.txt",mockObjectMapper);
    }

    @Test
    public void testGetNeeds() {
        // Invoke
        Need[] needs = cupboardFileDAO.getNeeds();

        // Analyze
        assertEquals(needs.length,testNeeds.length);
        for (int i = 0; i < testNeeds.length;++i)
            assertEquals(needs[i],testNeeds[i]);
    }

    @Test
    public void testFindNeeds() {
        // Invoke
        Need[] needs= cupboardFileDAO.findNeeds("Agent");

        // Analyze
        assertEquals(needs.length,1);
        assertEquals(needs[0],testNeeds[1]);
      
    }

    @Test
    public void testGetNeed() {
        // Invoke
        Need need = cupboardFileDAO.getNeed(0);

        // Analzye
        assertEquals(need,testNeeds[0]);
    }


}