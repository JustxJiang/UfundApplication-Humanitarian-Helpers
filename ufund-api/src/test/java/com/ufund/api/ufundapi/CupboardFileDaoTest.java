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
 * Test the Hero File DAO class
 * 
 * @author SWEN Faculty
 */
@Tag("Persistence-tier")
public class CupboardFileDaoTest {
    CupboardFileDao cupboardFileDao;
    Need[] testHeroes;
    ObjectMapper mockObjectMapper;

    /**
     * Before each test, we will create and inject a Mock Object Mapper to
     * isolate the tests from the underlying file
     * @throws IOException
     */
    @BeforeEach
    public void setupCuoboardFileDAO() throws IOException {
        mockObjectMapper = mock(ObjectMapper.class);
        testHeroes = new Need[3];
        testHeroes[0] = new Need(99,"Wi-Fire");
        testHeroes[1] = new Need(100,"Galactic Agent");
        testHeroes[2] = new Need(101,"Ice Gladiator");

        // When the object mapper is supposed to read from the file
        // the mock object mapper will return the hero array above
        when(mockObjectMapper
            .readValue(new File("doesnt_matter.txt"),Need[].class))
                .thenReturn(testHeroes);
        cupboardFileDao = new CupboardFileDao("doesnt_matter.txt",mockObjectMapper);
    }

    @Test
    public void testGetHeroes() {
        // Invoke
         Need[] needs = cupboardFileDao.getNeeds();

        // Analyze
        assertEquals(needs.length,testHeroes.length);
        for (int i = 0; i < testHeroes.length;++i)
            assertEquals(needs[i],testHeroes[i]);
    }

    @Test
    public void testFindHeroes() {
        // Invoke
        Need[] heroes = cupboardFileDao.findNeeds("la");

        // Analyze
        assertEquals(heroes.length,2);
        assertEquals(heroes[0],testHeroes[1]);
        assertEquals(heroes[1],testHeroes[2]);
    }
    

}
