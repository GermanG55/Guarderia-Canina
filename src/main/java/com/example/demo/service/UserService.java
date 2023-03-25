package com.example.demo.service;

import com.example.demo.controller.dto.UserDTO;

import java.util.List;

public interface UserService {
    public Boolean saveUser(UserDTO user);

    List<UserDTO> findAll();

    List<UserDTO> findByDocument(Integer document);
}
