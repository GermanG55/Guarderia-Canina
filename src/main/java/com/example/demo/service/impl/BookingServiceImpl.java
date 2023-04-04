package com.example.demo.service.impl;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Boolean saveBooking(Booking booking) {
        try {
            if (bookingRepository.countByDate(new java.sql.Date(booking.getDate().getTime()))<20 &&  bookingRepository.countByClient(booking.getClientId())<1 ){
                bookingRepository.save(booking);
                return true;
            }

        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> findByDate(Date date) {
        return bookingRepository.findByDate(new java.sql.Date(date.getTime()));
    }
}
