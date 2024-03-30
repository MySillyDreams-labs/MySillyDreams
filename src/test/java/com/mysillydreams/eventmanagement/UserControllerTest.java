package com.mysillydreams.eventmanagement;

import com.mysillydreams.eventmanagement.entity.User;
import com.mysillydreams.eventmanagement.rest.UserController;
import com.mysillydreams.eventmanagement.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserControllerTest {


    //line creates a mock object of the UserService interface using Mockito.
    // It specifies that when the findAll() method of the userService mock object is called, it should return the mockUsers list.
    @Mock
    private UserService userService;

    //It's expected to retrieve a list of users from the mocked userService dependency and return it
    @InjectMocks
    private UserController userController;

    private User user;
    private LocalDate myDate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        LocalDate myDate = LocalDate.of(2022, 3, 16);
        //user = new User("John", "Doe", "john@example.com", "1234567890", myDate);
        user = new User("John", "Doe", "john@example.com", "1234567890", myDate, "234445", LocalDateTime.now().plusMinutes(5));
    }

    @Test
    void testUserEntityList() {
        // Arrange
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(user);

        // creating mock object
        when(userService.findAll()).thenReturn(mockUsers);

        // Act
        List<User> users = userController.userEntityList();

        // Assert
        assertEquals(1, users.size());
        assertEquals("John", users.get(0).getFirstName());
        assertEquals("Doe", users.get(0).getLastName());
        assertEquals("john@example.com", users.get(0).getEmail());

    }

    @Test
    void testGetUserById(){

        //Arrange
        int userId = 1;

        when(userService.findById(userId)).thenReturn(user);

        //Act
        User foundUser = userController.getUserById(userId);

        //Assert
        assertEquals("John",foundUser.getFirstName());
    }

    @Test
    void testaddUserOrUsers(){

        //Arrange
        when(userService.save(user)).thenReturn(user);
        //Act
        ResponseEntity<?> savedUser = userController.addUserOrUsers(user);
        //Assert
        assertEquals("John", ((User) savedUser.getBody()).getFirstName());
    }

    @Test
    void testDeleteUser() {
        // Arrange
        int userId = 1;

        // Act
        // Here, we're expecting the deleteUser() method to throw a RuntimeException
        // when trying to delete a user with an ID that does not exist.
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userController.deleteUser(userId);
        });

        // Assert
        // Verify that the exception message contains the expected error message
        assertEquals("User id not found - " + userId, exception.getMessage());
        verify(userService, never()).deleteById(userId); // Ensure that deleteById was not called
    }

}
