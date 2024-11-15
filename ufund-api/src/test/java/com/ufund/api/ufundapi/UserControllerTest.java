package com.ufund.api.ufundapi;


import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ufund.api.controller.UserController;
import com.ufund.api.model.Need;
import com.ufund.api.persistence.CupboardDAO;

@Tag("Controller-tier")
public class UserControllerTest {
   private UserController userController;
   private CupboardDAO mockCupboardDAO;

   public UserControllerTest() {
   }

   @BeforeEach
   public void setupUserController() {
      this.mockCupboardDAO = (CupboardDAO)Mockito.mock(CupboardDAO.class);
      this.userController = new UserController(this.mockCupboardDAO);
   }

   @Test
   public void testGetNeed() throws IOException {
      Need need = new Need("Bob", 1);
      Mockito.when(this.mockCupboardDAO.getNeed(need.getId())).thenReturn(need);
      ResponseEntity<Need> response = this.userController.getNeed(need.getId());
      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertEquals(need, response.getBody());
   }

   @Test
   public void testGetNeedNotFound() throws Exception {
      int needId = 99;
      Mockito.when(this.mockCupboardDAO.getNeed(needId)).thenReturn((Need)null);
      ResponseEntity<Need> response = this.userController.getNeed(needId);
      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
   }

   @Test
   public void testGetNeedHandleException() throws Exception {
      int needId = 99;
      ((CupboardDAO)Mockito.doThrow(new Throwable[]{new IOException()}).when(this.mockCupboardDAO)).getNeed(needId);
      ResponseEntity<Need> response = this.userController.getNeed(needId);
      Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
   }

   @Test
   public void testCreateNeedFailed() throws IOException {
      Need need = new Need("Bolt", 99);
      Mockito.when(this.mockCupboardDAO.createNeed(need)).thenReturn((Need)null);
      ResponseEntity<Need> response = this.userController.createNeed(need);
      Assertions.assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
   }

   @Test
   public void testCreateNeedHandleException() throws IOException {
      Need need = new Need("Ice Gladiator", 4);
      ((CupboardDAO)Mockito.doThrow(new Throwable[]{new IOException()}).when(this.mockCupboardDAO)).createNeed(need);
      ResponseEntity<Need> response = this.userController.createNeed(need);
      Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
   }

   @Test
   public void testUpdateNeed() throws IOException {
      Need need = new Need("Food", 5);
      Mockito.when(this.mockCupboardDAO.getNeed(need.getId())).thenReturn(need);
      Mockito.when(this.mockCupboardDAO.updateNeed(need)).thenReturn(need);
      this.userController.updateNeed(need.getId(), need);
      need.setName("Bolt");
      Mockito.when(this.mockCupboardDAO.updateNeed(need)).thenReturn(need);
      ResponseEntity<Need> response = this.userController.updateNeed(need.getId(),need);
      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertEquals(need, response.getBody());
   }

   @Test
   public void testUpdateNeedFailed() throws IOException {
        Need need = new Need("Galactic Agent", 99);
        when(mockCupboardDAO.updateNeed(need)).thenReturn(null);
        ResponseEntity<Need> response = userController.updateNeed(need.getId(),need);
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }
   @Test
   public void testUpdateNeedHandleException() throws IOException { 
        Need need = new Need("Galactic Agent", 99);
        when(mockCupboardDAO.getNeed(need.getId())).thenReturn(need);
        doThrow(new IOException()).when(mockCupboardDAO).updateNeed(need);
        ResponseEntity<Need> response = userController.updateNeed(need.getId(),need);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
    }
    
    @Test
    public void testGetNeedsHandleException() throws IOException { 
        doThrow(new IOException()).when(mockCupboardDAO).getNeeds();
        ResponseEntity<Need[]> response = userController.getNeeds();
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

   @Test
   public void testGetNeeds() throws IOException {
        Need[] need = new Need[2];
        need[0] = new Need("Bolt", 1);
        need[1] = new Need("The Great Iguana", 2);
        when(mockCupboardDAO.getNeeds()).thenReturn(need);
        ResponseEntity<Need[]> response = userController.getNeeds();
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void testSearchNeedsHandleException() throws IOException {
        String searchString = "an";
        doThrow(new IOException()).when(mockCupboardDAO).findNeeds(searchString);
        ResponseEntity<Need[]> response = userController.searchNeeds(searchString);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
    }
    @Test
    public void testDeleteNeedHandleException() throws IOException {
        int needId = 99;
        doThrow(new IOException()).when(mockCupboardDAO).deleteNeed(needId);
        ResponseEntity<Need> response = userController.deleteNeed(needId);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
    }

    @Test
     void testDeleteNeed() throws IOException{
        Need need = new Need("testNeed", 99);
        Need[] needs = new Need[]{need};
        Mockito.when(this.mockCupboardDAO.getNeeds()).thenReturn(needs);
        Mockito.when(this.mockCupboardDAO.deleteNeed(need.getId())).thenReturn(true);
        ResponseEntity<Need> response = this.userController.deleteNeed(need.getId());
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @SuppressWarnings("null")
   @Test 
    void testSearchNeed() throws IOException{
        String name = "Bread";
        Need need = new Need("Bread", 5);
        Need[] needs = new Need[]{need};
        Mockito.when(this.mockCupboardDAO.getNeeds()).thenReturn(needs);
        ResponseEntity<Need[]> response = this.userController.searchNeeds(name);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(1,response.getBody().length);
        assertEquals(need,response.getBody()[0]);
    }
}

