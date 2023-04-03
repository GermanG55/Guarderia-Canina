package com.example.demo.service.impl;

import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.PetService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;
    @Override
    public Boolean savePet(Pet pet) {
        boolean result;
        ArrayList<Pet> petList = new ArrayList<>();
        if (petList.size() <= 20) {
            try {
                petRepository.save(pet);
                result = true;
            } catch (Exception e) {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public List<Pet> findByOwnerDocument(Integer ownerDocument) {
        return petRepository.findByOwnerDocument(ownerDocument);
    }
}
