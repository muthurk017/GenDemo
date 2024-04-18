package com.gen.demo.controller;

import com.gen.demo.domain.User;
import com.gen.demo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // Create operation
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        logger.info("User created with ID: " + createdUser.getId());
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Read operation
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user != null) {
            logger.info("User retrieved with ID: " + user.getId());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Read all operation
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        logger.info("All users retrieved");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Update operation
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            logger.info("User updated with ID: " + updatedUser.getId());
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            logger.info("User deleted with ID: " + id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // New API to check if user exists based on email
    @GetMapping("/exists/email/{email}")
    public ResponseEntity<Boolean> checkUserExistsByEmail(@PathVariable String email) {
        boolean exists = userService.existsByEmail(email);
        logger.info("Checking if user exists with email: " + email);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    // New API to check if user exists based on userName
    @GetMapping("/exists/username/{userName}")
    public ResponseEntity<Boolean> checkUserExistsByUserName(@PathVariable String userName) {
        boolean exists = userService.existsByUserName(userName);
        logger.info("Checking if user exists with username: " + userName);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    // New API for searching users by name, userName, and email
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String email
    ) {
        List<User> users = userService.searchUsers(name, userName, email);
        logger.info("Searching users with name: " + name + ", userName: " + userName + ", email: " + email);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}