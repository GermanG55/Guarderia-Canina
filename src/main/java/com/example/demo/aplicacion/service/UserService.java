package com.example.demo.aplicacion.service;

import com.example.demo.dominio.model.UserModel;

import java.util.List;

public interface UserService {
    void saveUser(UserModel user);

    List<UserModel> findAll();

    List<UserModel> findBookingByDocument(Integer document);

    List<UserModel> findPetsByDocument(Integer document);
}
