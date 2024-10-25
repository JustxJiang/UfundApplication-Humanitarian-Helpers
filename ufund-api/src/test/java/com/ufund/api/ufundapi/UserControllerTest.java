package com.ufund.api.ufundapi;


import com.ufund.api.controller.UserController;
import com.ufund.api.model.Need;
import com.ufund.api.persistence.CupboardDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
      Need need = new Need(1, "Bob");
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
   public void testCreateNeed() throws IOException {
      Need need = new Need(25, "Toys");
      Mockito.when(this.mockCupboardDAO.createNeed(need)).thenReturn(need);
      ResponseEntity<Need> response = this.userController.createNeed(need);
      Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
      Assertions.assertEquals(need, response.getBody());
   }

   @Test
   public void testCreateNeedFailed() throws IOException {
      Need need = new Need(99, "Bolt");
      Mockito.when(this.mockCupboardDAO.createNeed(need)).thenReturn((Need)null);
      ResponseEntity<Need> response = this.userController.createNeed(need);
      Assertions.assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
   }

   @Test
   public void testCreateNeedHandleException() throws IOException {
      Need need = new Need(99, "Ice Gladiator");
      ((CupboardDAO)Mockito.doThrow(new Throwable[]{new IOException()}).when(this.mockCupboardDAO)).createNeed(need);
      ResponseEntity<Need> response = this.userController.createNeed(need);
      Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
   }

   @Test
   public void testUpdateNeed() throws IOException {
      Need need = new Need(2, "Food");
      Mockito.when(this.mockCupboardDAO.updateNeed(need)).thenReturn(need);
      this.userController.updateNeed(need);
      need.setName("Bolt");
      ResponseEntity<Need> response = this.userController.updateNeed(need);
      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertEquals(need, response.getBody());
   }

   @Test
   public void testUpdateNeedFailed() throws IOException {
        Need need = new Need(99,"Galactic Agent");
        when(mockCupboardDAO.updateNeed(need)).thenReturn(null);
        ResponseEntity<Need> response = userController.updateNeed(need);
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
   @Test
   public void testUpdateNeedHandleException() throws IOException { 
        Need need = new Need(99,"Galactic Agent");
        doThrow(new IOException()).when(mockCupboardDAO).updateNeed(need);
        ResponseEntity<Need> response = userController.updateNeed(need);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
    }
   @Test
   public void testGetNeeds() throws IOException {
        Need[] need = new Need[2];
        need[0] = new Need(1,"Bolt");
        need[1] = new Need(2,"The Great Iguana");
        when(mockCupboardDAO.getNeeds()).thenReturn(need);
        ResponseEntity<Need[]> response = userController.getNeeds();
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
}
