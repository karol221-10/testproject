package com.example.demo.controller;

import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/api/user")
    Integer addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @GetMapping("/api/users/{id}")
    User getSingleUser(@PathVariable("id") Integer id) throws UserNotFoundException {
        return userService.getSingleUser(id);
    }
}
