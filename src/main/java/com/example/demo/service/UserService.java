package com.example.demo.service;

import com.example.demo.model.UserModel;

import java.util.List;

public interface UserService {
    void saveUser(UserModel user);

    List<UserModel> findAll();

    List<UserModel> findBookingByDocument(Integer document);

    List<UserModel> findPetsByDocument(Integer document);
}
