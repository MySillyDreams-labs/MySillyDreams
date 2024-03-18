package com.mysillydreams.eventmanagement.rest;

import com.mysillydreams.eventmanagement.entity.User;
import com.mysillydreams.eventmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userapi")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> userEntityList(){
        return userService.findAll();
    }
    @GetMapping("users/{userId}")
    public User getUserById(@PathVariable int userId){

        User theUser = userService.findById(userId);

        if(theUser == null) {
            throw  new RuntimeException("User id not found - " + userId);
        }
        return theUser;
    }

    // add user
    @PostMapping("/users")
    public ResponseEntity<?> addUserOrUsers(@RequestBody User users) {

        try {
            // Set id to 0 to force save a new item
            users.setId(0);
            // Save the user
            userService.save(users);
            // Return the single user
            return ResponseEntity.ok(users);

        } catch (Exception e) {
            // Check if the exception is due to duplicate email or mobile number
            if (e.getMessage().contains("email") || e.getMessage().contains("mobile_number")) {
                // Return a bad request response with an error message indicating the duplicate field
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate email or mobile number");

            } else if (users.getMobileNumber().length() < 10) {
                // Check if the mobile number is less than 10 digits
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mobile number should be at least 10 digits");
            } else {
                // Return a server error response if the exception is not due to duplicate email or mobile number
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while saving user");
            }

        }
    }

    // add mapping for PUT / users - update existing user
    @PutMapping("/users")
    public User updateUser(@RequestBody User user){

        User theUser = userService.save(user);
        return theUser;
    }

    //add mapping for DELETE / users/{userId} - delete user
    @DeleteMapping("users/{userId}")
    public String deleteUser(@PathVariable int userId){
        User theUser = userService.findById(userId);

        // throw exception if null

        if(theUser == null) {
            throw  new RuntimeException("User id not found - " + userId);
        }
        userService.deleteById(userId);

        return " Deleted user id - " + userId;
    }
}