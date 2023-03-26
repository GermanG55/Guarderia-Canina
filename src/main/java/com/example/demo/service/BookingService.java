package com.example.demo.service;

import com.example.demo.controller.dto.BookingDTO;

import java.util.Date;
import java.util.List;

public interface BookingService {

    Boolean saveBooking(BookingDTO booking);

    List<BookingDTO> findAll();

    List<BookingDTO> findBookingByBookingId(Integer bookingId);

    List<BookingDTO> findByDate( String date);
}
