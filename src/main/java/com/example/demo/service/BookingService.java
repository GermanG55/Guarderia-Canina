package com.example.demo.service;

import com.example.demo.model.Booking;

import java.util.List;

public interface BookingService {

    Boolean saveBooking(Booking booking);

    List<Booking> findAll();

    List<Booking> findBookingByBookingId(Integer bookingId);

    List<Booking> findByDate(String date);
}
