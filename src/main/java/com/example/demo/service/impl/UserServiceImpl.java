package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.controller.dto.UserDTO;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Boolean saveUser(UserDTO user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDTO> findByDocument(Integer document) {
        return userRepository.findByDocument(document);
    }
}
