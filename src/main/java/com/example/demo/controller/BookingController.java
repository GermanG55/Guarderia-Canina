package com.example.demo.controller;

import com.example.demo.controller.dto.BookingDto;
import com.example.demo.model.BookingModel;
import com.example.demo.service.BookingService;
import com.example.demo.service.rabbitmq.NotifyServiceResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/booking")
public class BookingController {

private final BookingService bookingService;

    private NotifyServiceResource notifyServiceResource;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(value = "/saveBooking")
    public void saveBooking(@RequestBody BookingDto booking){
     bookingService.saveBooking(booking.toModel());
    }
    @GetMapping(path = "/all")
    public List<BookingModel> findAll(){
        return bookingService.findAll();
    }
    @GetMapping(path = "/date")
    public List<BookingModel> findByDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        return bookingService.findByDate(date);
    }
    @GetMapping(path = "/send-notification/{notification}")
    void sendInstructions(@PathVariable String notification){
        notifyServiceResource.sendNotification(notification);
    }
}
