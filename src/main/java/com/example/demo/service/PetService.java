package com.example.demo.service;

import com.example.demo.model.PetModel;

import java.util.List;

public interface PetService {
    void savePet(PetModel pet);

    List<PetModel> findAll();

    List<PetModel> findByOwnerDocument(Integer ownerDocument);
}
