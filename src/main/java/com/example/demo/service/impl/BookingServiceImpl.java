package com.example.demo.service.impl;

import com.example.demo.model.BookingModel;
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

    public void saveBooking(BookingModel booking) {
        try {
            if (bookingRepository.countByDate(new java.sql.Date(booking.getDate().getTime()))<20 &&  bookingRepository.countByClient(booking.getClientId())<1 )
            {bookingRepository.save(booking);}
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<BookingModel> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<BookingModel> findByDate(Date date) {
        return bookingRepository.findByDate(new java.sql.Date(date.getTime()));
    }
}
