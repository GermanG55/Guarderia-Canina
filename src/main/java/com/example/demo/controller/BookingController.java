package com.example.demo.controller;

import com.example.demo.controller.dto.BookingDTO;
import com.example.demo.controller.dto.PetDTO;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/booking")
public class BookingController {

    @Autowired
    private BookingService BookingServices;
    @RequestMapping(value="/saveBooking",method= RequestMethod.POST)
    public Boolean saveBooking(@RequestBody BookingDTO u){
        return BookingServices.saveBooking(u);
    }
    @GetMapping(path = "/all")
    public List<BookingDTO> findAll(){
        return BookingServices.findAll();
    }
    @GetMapping(path = "/date")
    public List<BookingDTO> findByDate(@RequestParam String date){
        return BookingServices.findByDate(date);
    }

}
