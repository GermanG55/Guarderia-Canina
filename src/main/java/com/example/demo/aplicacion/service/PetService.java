package com.example.demo.aplicacion.service;

import com.example.demo.dominio.model.PetModel;

import java.util.List;

public interface PetService {
    void savePet(PetModel pet);

    List<PetModel> findAll();

    List<PetModel> findByOwnerDocument(Integer ownerDocument);
}
