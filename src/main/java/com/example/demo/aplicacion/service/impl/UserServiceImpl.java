package com.example.demo.aplicacion.service.impl;

import com.example.demo.dominio.model.UserModel;
import org.springframework.stereotype.Service;
import com.example.demo.aplicacion.service.UserService;
import com.example.demo.infrastructura.repository.UserRepository;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserModel user) {
        try {
            userRepository.save(user);
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserModel> findBookingByDocument(Integer document) {
        return userRepository.findBookingByDocument(document);
    }
    @Override
    public List<UserModel> findPetsByDocument(Integer document) {
        return userRepository.findPetsByDocument(document);
    }
}
