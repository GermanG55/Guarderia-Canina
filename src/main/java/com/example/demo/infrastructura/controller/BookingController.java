package com.example.demo.infrastructura.controller;

import com.example.demo.infrastructura.controller.dto.BookingDto;
import com.example.demo.dominio.model.BookingModel;
import com.example.demo.aplicacion.service.BookingService;
import com.example.demo.infrastructura.rabbitmq.NotifyServiceResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/booking")
public class BookingController {

    private final BookingService bookingService;

    private NotifyServiceResource notifyServiceResource;

    public BookingController(BookingService bookingService, NotifyServiceResource notifyServiceResource) {
        this.bookingService = bookingService;
        this.notifyServiceResource = notifyServiceResource;
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
    void sendNotification(@PathVariable String notification){
        notifyServiceResource.sendNotification(notification);
    }
}
