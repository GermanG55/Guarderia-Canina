package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.Pet;
import com.example.demo.model.User;
import com.example.demo.service.BookingService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {
    @Mock
    BookingService bookingService;
    @InjectMocks
    BookingController bookingController ;

    @Test
    public void findAll(){
        Mockito.when(bookingService.findAll()).thenReturn(bookingList());
        List<Booking> result = bookingController.findAll();
        assertEquals(1, result.size());
        Assertions.assertThat(result);
        Mockito.verify(bookingService).findAll();
    }
    private List<Booking> bookingList(){
        List<Booking> bookingList= new ArrayList<>();
        Booking booking = new Booking();
        booking.setBookingId(123);
        booking.setClientId(123);
        booking.setDate(new Date());
        booking.setPetId(123);
        bookingList.add(booking);
        return bookingList;
    }

}
