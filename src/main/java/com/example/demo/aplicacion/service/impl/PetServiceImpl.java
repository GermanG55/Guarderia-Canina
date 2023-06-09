package com.example.demo.aplicacion.service.impl;

import com.example.demo.dominio.model.PetModel;
import com.example.demo.infrastructura.repository.PetRepository;
import com.example.demo.aplicacion.service.PetService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void savePet(PetModel pet) {

        try {
            if(petRepository.countByClient(pet.getOwnerDocument())<2){
                petRepository.save(pet);}
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public List<PetModel> findAll() {
        return petRepository.findAll();
    }

    @Override
    public List<PetModel> findByOwnerDocument(Integer ownerDocument) {
        return petRepository.findByOwnerDocument(ownerDocument);
    }
}
