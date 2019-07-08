package com.example.demo.service;

import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    Integer addUser(User user);
    User getSingleUser(Integer id) throws UserNotFoundException;
}
