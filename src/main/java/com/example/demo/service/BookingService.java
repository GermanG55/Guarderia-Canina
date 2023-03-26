package com.example.demo.service;

import com.example.demo.controller.dto.BookingDTO;
import com.example.demo.controller.dto.PetDTO;

import java.util.List;

public interface BookingService {
    public Boolean saveBooking(BookingDTO booking);

    List<BookingDTO> findAll();

    List<BookingDTO> findByBookedDocument(Integer bookeddocument);
}
