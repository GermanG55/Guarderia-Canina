package com.example.demo.controller;

import com.example.demo.controller.dto.PetDTO;
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
    public Boolean savePet(@RequestBody PetDTO u){
        return petServices.savePet(u);
    }
    @GetMapping(path = "/all")
    public List<PetDTO> findAll(){
        return petServices.findAll();
    }

}
