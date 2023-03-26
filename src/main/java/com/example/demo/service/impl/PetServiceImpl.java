package com.example.demo.service.impl;

import com.example.demo.controller.dto.PetDTO;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;
    @Override
    public Boolean savePet(PetDTO pet) {
        boolean result;
        ArrayList<PetDTO> petDTOList = new ArrayList<>();
        if (petDTOList.size() <= 20) {
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
    public List<PetDTO> findAll() {
        return petRepository.findAll();
    }

    @Override
    public List<PetDTO> findByOwnerDocument(Integer ownerDocument) {
        return petRepository.findByOwnerDocument(ownerDocument);
    }
}
