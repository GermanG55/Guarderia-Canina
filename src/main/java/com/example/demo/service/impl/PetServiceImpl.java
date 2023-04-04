package com.example.demo.service.impl;

import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.PetService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Boolean savePet(Pet pet) {

        try {
            if(petRepository.countByClient(pet.getOwnerDocument())<2){
                petRepository.save(pet);
            return true;}
            } catch (Exception e) {
            throw e;
            }
        return false;
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
