package com.example.demo.service;

import com.example.demo.model.Booking;

import java.util.Date;
import java.util.List;

public interface BookingService {

    Boolean saveBooking(Booking booking);

    List<Booking> findAll();

    List<Booking> findByDate(Date date);
}
