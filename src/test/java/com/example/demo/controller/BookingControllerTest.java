package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.assertj.core.api.Assertions;
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

    private List<Booking> bookingList(){
        List<Booking> bookingList= new ArrayList<>();
        Booking booking = new Booking();
        booking.setBookingId(123);
        booking.setClientId(173);
        booking.setDate(new Date());
        booking.setPetId(340);
        bookingList.add(booking);
        return bookingList;
    }

    @Mock
    BookingService bookingService;
    @InjectMocks
    BookingController bookingController ;

    @Test
    public void Given_Find_All_Values_When_Values_Arent_Empty_Then_Return_Existing_List_As_Not_Empty (){
        Mockito.when(bookingService.findAll()).thenReturn(bookingList());
        List<Booking> result = bookingController.findAll();
        assertEquals(1, result.size());
        Assertions.assertThat(result);
        Mockito.verify(bookingService).findAll();
    }
}
