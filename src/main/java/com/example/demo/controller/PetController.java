package com.example.demo.controller;

import com.example.demo.model.Pet;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/pets")
public class PetController {

    @Autowired
    private PetService petServices;
    @RequestMapping(value="/savePet",method= RequestMethod.POST)
    public Boolean savePet(@RequestBody Pet u){
        return petServices.savePet(u);
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
