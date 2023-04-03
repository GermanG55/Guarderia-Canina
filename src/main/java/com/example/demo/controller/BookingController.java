package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/booking")
public class BookingController {

    @Autowired
    private BookingService BookingServices;
    @RequestMapping(value="/saveBooking",method= RequestMethod.POST)
    public Boolean saveBooking(@RequestBody Booking u){
        return BookingServices.saveBooking(u);
    }
    @GetMapping(path = "/all")
    public List<Booking> findAll(){
        return BookingServices.findAll();
    }
    @GetMapping(path = "/date")
    public List<Booking> findByDate(@RequestParam String date){
        return BookingServices.findByDate(date);
    }

}
