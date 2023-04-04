package com.example.demo.controller;

import com.example.demo.model.Pet;
import com.example.demo.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/pets")
public class PetController {

    private final PetService petServices;

    public PetController(PetService petServices) {
        this.petServices = petServices;
    }

    @RequestMapping(value="/savePet",method= RequestMethod.POST)
    public Boolean savePet(@RequestBody Pet pet){
        return petServices.savePet(pet);
    }
    @GetMapping(path = "/all")
    public List<Pet> findAll(){
        return petServices.findAll();
    }
    @GetMapping("{document}")
    public List<Pet> findByOwnerDocument(@RequestParam Integer ownerDocument){
        return petServices.findByOwnerDocument(ownerDocument);
    }

}
