package com.example.demo.service;

import com.example.demo.controller.dto.PetDTO;
import com.example.demo.controller.dto.UserDTO;

import java.util.List;

public interface PetService {
    public Boolean savePet(PetDTO pet);

    List<PetDTO> findAll();

    List<PetDTO> findByOwnerDocument(Integer ownerDocument);
}
