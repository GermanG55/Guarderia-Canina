package com.example.demo.controller;

import com.example.demo.controller.dto.BookingDTO;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingServices;
    @RequestMapping(value="/saveBooking",method= RequestMethod.POST)
    public Boolean saveBooking(@RequestBody BookingDTO u){
        return bookingServices.saveBooking(u);
    }
    @GetMapping(path = "/all")
    public List<BookingDTO> findAll(){
        return bookingServices.findAll();
    }

}
