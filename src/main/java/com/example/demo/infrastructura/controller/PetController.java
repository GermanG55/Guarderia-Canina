package com.example.demo.infrastructura.controller;

import com.example.demo.infrastructura.controller.dto.PetDto;
import com.example.demo.dominio.model.PetModel;
import com.example.demo.aplicacion.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }
    @PostMapping(value="/savePet")
    public void savePet(@RequestBody PetDto pet){
        petService.savePet(pet.toModel());
    }
    @GetMapping(path = "/all")
    public List<PetModel> findAll(){
        return petService.findAll();
    }
    @GetMapping("{document}")
    public List<PetModel> findByOwnerDocument(@RequestParam Integer ownerDocument){
        return petService.findByOwnerDocument(ownerDocument);
    }

}
