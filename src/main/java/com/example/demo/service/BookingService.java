package com.example.demo.service;

import com.example.demo.controller.dto.BookingDTO;
import java.util.List;

public interface BookingService {

    Boolean saveBooking(BookingDTO booking);

    List<BookingDTO> findAll();

    List<BookingDTO> findByBookingId(Integer bookingId);
}
