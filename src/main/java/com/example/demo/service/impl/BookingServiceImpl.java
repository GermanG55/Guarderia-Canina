package com.example.demo.service.impl;

import com.example.demo.controller.dto.BookingDTO;
import com.example.demo.controller.dto.UserDTO;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public Boolean saveBooking(BookingDTO booked) {
        try {
            bookingRepository.save(booked);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<BookingDTO> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<BookingDTO> findByBookedDocument(Integer bookeddocument) {
        return bookingRepository.findByBookedDocument(bookeddocument);
    }
}
