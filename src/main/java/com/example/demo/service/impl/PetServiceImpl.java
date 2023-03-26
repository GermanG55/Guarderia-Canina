package com.example.demo.service.impl;

import com.example.demo.controller.dto.PetDTO;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;
    @Override
    public Boolean savePet(PetDTO pet) {
        try {
            petRepository.save(pet);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<PetDTO> findAll() {
        return petRepository.findAll();
    }

    @Override
    public List<PetDTO> findByOwnerDocument(Integer ownerdocument) {
        return petRepository.findByOwnerDocument(ownerdocument);
    }
}
