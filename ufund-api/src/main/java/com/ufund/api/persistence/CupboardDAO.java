package com.ufund.api.persistence;
import java.io.IOException;
import com.ufund.api.model.Need;

/**
 * Defines the interface for Hero object persistence
 * 
 * @author SWEN Faculty
 */
public interface CupboardDAO {
    /**
     * Retrieves all {@linkplain Hero heroes}
     * 
     * @return An array of {@link Hero hero} objects, may be empty
     * 
     * @throws IOException if an issue with underlying storage
     */
    Need[] getNeeds() throws IOException;

    /**
     * Finds all {@linkplain Hero heroes} whose name contains the given text
     * 
     * @param containsText The text to match against
     * 
     * @return An array of {@link Hero heroes} whose nemes contains the given text, may be empty
     * 
     * @throws IOException if an issue with underlying storage
     */
    Need[] findNeeds(String containsText) throws IOException;

    /**
     * Retrieves a {@linkplain Hero hero} with the given id
     * 
     * @param id The id of the {@link Hero hero} to get
     * 
     * @return a {@link Hero hero} object with the matching id
     * <br>
     * null if no {@link Hero hero} with a matching id is found
     * 
     * @throws IOException if an issue with underlying storage
     */
    Need getNeed(int id) throws IOException;

    /**
     * Creates and saves a {@linkplain Hero hero}
     * 
     * @param hero {@linkplain Hero hero} object to be created and saved
     * <br>
     * The id of the hero object is ignored and a new uniqe id is assigned
     *
     * @return new {@link Hero hero} if successful, false otherwise 
     * 
     * @throws IOException if an issue with underlying storage
     */
    Need createNeed(Need need) throws IOException;

    /**
     * Updates and saves a {@linkplain Hero hero}
     * 
     * @param {@link Hero hero} object to be updated and saved
     * 
     * @return updated {@link Hero hero} if successful, null if
     * {@link Hero hero} could not be found
     * 
     * @throws IOException if underlying storage cannot be accessed
     */
    Need updateNeed(Need need) throws IOException;

    /**
     * Deletes a {@linkplain Hero hero} with the given id
     * 
     * @param id The id of the {@link Hero hero}
     * 
     * @return true if the {@link Hero hero} was deleted
     * <br>
     * false if hero with the given id does not exist
     * 
     * @throws IOException if underlying storage cannot be accessed
     */
    boolean deleteNeed(int id) throws IOException;
}

