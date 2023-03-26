package com.example.demo.service.impl;

import com.example.demo.controller.dto.BookingDTO;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public Boolean saveBooking(BookingDTO booking) {
        try {
            bookingRepository.save(booking);

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
    public List<BookingDTO> findByBookingId(Integer BookingId) {
        return null;
    }
}
