package com.example.demo.service;


import com.example.demo.model.BookingModel;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public interface BookingService {

    void saveBooking(BookingModel booking);

    List<BookingModel> findAll();

    List<BookingModel> findByDate(Date date);
}

