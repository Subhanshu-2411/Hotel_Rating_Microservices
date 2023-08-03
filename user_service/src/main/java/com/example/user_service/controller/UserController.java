package com.example.user_service.controller;

import com.example.user_service.models.User;
import com.example.user_service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    @CircuitBreaker(name = "AllUserRating", fallbackMethod = "AllUserRating")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    public ResponseEntity<List<User>> AllUserRating() {
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
    }

    @GetMapping("/get/{userId}")
    @CircuitBreaker(name = "UserRating", fallbackMethod = "UserRating")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
    }

    public ResponseEntity<User> UserRating() {
        return ResponseEntity.status(HttpStatus.OK).body(new User());
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") String userId, @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(userId, user));
    }

    @DeleteMapping("delete/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
    }
}
