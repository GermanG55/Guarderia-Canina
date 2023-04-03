package com.example.demo.service;

import com.example.demo.model.Pet;

import java.util.List;

public interface PetService {
    public Boolean savePet(Pet pet);

    List<Pet> findAll();

    List<Pet> findByOwnerDocument(Integer ownerDocument);
}
