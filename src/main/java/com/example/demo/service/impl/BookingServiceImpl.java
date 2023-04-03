package com.example.demo.service.impl;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    @Override
    public Boolean saveBooking(Booking booking) {
        try {
            bookingRepository.save(booking);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> findBookingByBookingId(Integer BookingId) {
        return null;
    }

    @Override
    public List<Booking> findByDate(String date) {
        return bookingRepository.findByDate("'"+ date +"'");
    }
}
