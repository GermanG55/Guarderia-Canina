package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userServices;
    @RequestMapping(value="/saveUser",method= RequestMethod.POST)
    public Boolean saveUser(@RequestBody User user){
        return userServices.saveUser(user);
    }
    @GetMapping(path = "/all")
    public List<User> findAll(){
        return userServices.findAll();
    }

    @GetMapping("/bookings")
    public List<User> findBookingByDocument(@RequestParam Integer document){

        return userServices.findBookingByDocument(document);
    }
    @GetMapping("/pets")
    public List<User> findPetsByDocument(@RequestParam Integer document){

        return userServices.findPetsByDocument(document);
    }
}
