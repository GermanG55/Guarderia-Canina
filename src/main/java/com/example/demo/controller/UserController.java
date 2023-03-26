package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.controller.dto.UserDTO;
import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userServices;
    @RequestMapping(value="/saveUser",method= RequestMethod.POST)
    public Boolean saveUser(@RequestBody UserDTO u){
        return userServices.saveUser(u);
    }
    @GetMapping(path = "/all")
    public List<UserDTO> findAll(){
        return userServices.findAll();
    }

    @GetMapping("/bookings")
    public List<UserDTO> findBookingByDocument(@RequestParam Integer document){

        return userServices.findBookingByDocument(document);
    }
    @GetMapping("/pets")
    public List<UserDTO> findPetsByDocument(@RequestParam Integer document){

        return userServices.findPetsByDocument(document);
    }
}
