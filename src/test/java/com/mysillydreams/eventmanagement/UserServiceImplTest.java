package com.mysillydreams.eventmanagement;

import com.mysillydreams.eventmanagement.dao.UserRepository;
import com.mysillydreams.eventmanagement.entity.User;
import com.mysillydreams.eventmanagement.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private LocalDate myDate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        myDate = LocalDate.of(2022, 3, 16);
        user = new User("John", "Doe", "john@example.com", "1234567890", myDate);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(user);
        when(userRepository.findAll()).thenReturn(mockUsers);

        // Act
        List<User> users = userService.findAll();

        // Assert
        assertEquals(1, users.size());
        assertEquals("John", users.get(0).getFirstName());
    }

    @Test
    void testFindById() {
        // Arrange
        int userId = 1;
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        User foundUser = userService.findById(userId);

        // Assert
        assertEquals("Doe", foundUser.getLastName());
    }

    @Test
    void testSave() {
        // Arrange
        when(userRepository.save(user)).thenReturn(user);

        // Act
        User savedUser = userService.save(user);

        // Assert
        assertEquals("john@example.com", savedUser.getEmail());
    }

    @Test
    void testDeleteById() {
        // Arrange
        int userId = 1;

        // Act
        userService.deleteById(userId);

        // Assert
        verify(userRepository, times(1)).deleteById(userId);
    }
}