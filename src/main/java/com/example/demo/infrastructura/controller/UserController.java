package com.example.demo.infrastructura.controller;

import com.example.demo.infrastructura.controller.dto.UserDto;
import com.example.demo.dominio.model.UserModel;
import com.example.demo.aplicacion.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/user")
public class UserController {

    private final UserService userServices;

    public UserController(UserService userServices) {
        this.userServices = userServices;
    }

    @PostMapping(value="/saveUser")
    public void saveUser(@RequestBody UserDto user){
         userServices.saveUser(user.toModel());
    }
    @GetMapping(path = "/all")
    public List<UserModel> findAll(){
        return userServices.findAll();
    }
    @GetMapping("/bookings")
    public List<UserModel> findBookingByDocument(@RequestParam Integer document){ return userServices.findBookingByDocument(document);}
    @GetMapping("/pets")
    public List<UserModel> findPetsByDocument(@RequestParam Integer document){

        return userServices.findPetsByDocument(document);
    }
}