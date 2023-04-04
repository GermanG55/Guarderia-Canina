package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Boolean saveUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findBookingByDocument(Integer document) {
        return userRepository.findBookingByDocument(document);
    }
    @Override
    public List<User> findPetsByDocument(Integer document) {
        return userRepository.findPetsByDocument(document);
    }
}
