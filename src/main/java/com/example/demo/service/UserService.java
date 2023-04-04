package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    Boolean saveUser(User user);

    List<User> findAll();

    List<User> findBookingByDocument(Integer document);

    List<User> findPetsByDocument(Integer document);
}
