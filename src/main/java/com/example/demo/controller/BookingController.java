package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/booking")
public class BookingController {

    private final BookingService BookingServices;

    public BookingController(BookingService BookingServices) {
        this.BookingServices = BookingServices;
    }

    @RequestMapping(value="/saveBooking",method= RequestMethod.POST)
    public Boolean saveBooking(@RequestBody Booking booking){
        return BookingServices.saveBooking(booking);
    }
    @GetMapping(path = "/all")
    public List<Booking> findAll(){
        return BookingServices.findAll();
    }
    @GetMapping(path = "/date")
    public List<Booking> findByDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")Date date){
        return BookingServices.findByDate(date);
    }

}
