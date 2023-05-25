package com.example.demo.service.impl;

import com.example.demo.infrastructura.controller.dto.BookingDto;
import com.example.demo.dominio.model.BookingModel;
import com.example.demo.aplicacion.service.impl.BookingServiceImpl;
import com.example.demo.infrastructura.repository.BookingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class BookingServiceImplTest {

    @InjectMocks
    BookingServiceImpl bookingServiceImpl;
    @Mock
    BookingRepository bookingRepository;
    private BookingDto booking;

    @Test
    public void Given_A_Booking_When_Save_Booking_Is_Cast_And_Both_Conditions_Are_True_Then_Save_User(){
        booking = new BookingDto(1,1,null,1,null,new java.util.Date());
        Mockito.when(bookingRepository.save(any(BookingModel.class))).thenReturn(booking.toModel());
        Mockito.when(bookingRepository.countByClient(any(Integer.class))).thenReturn(0);
        Mockito.when(bookingRepository.countByDate(any(Date.class))).thenReturn(3);

        bookingServiceImpl.saveBooking(booking.toModel());

        Mockito.verify(bookingRepository).save(booking.toModel());
        Mockito.verify(bookingRepository).countByClient(1);
        Mockito.verify(bookingRepository).countByDate(any(Date.class));
    }
    @Test
    public void Given_A_Booking_With_Null_Fields_When_Save_Booking_Is_Cast_Then_Throw_An_Illegal_Argument_Exception(){

        booking = new BookingDto(1,1,null,1,null,new java.util.Date());
        Mockito.when(bookingRepository.save(any(BookingModel.class))).thenThrow(new IllegalArgumentException());

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        bookingServiceImpl.saveBooking(booking.toModel()),
                "Esperaba campos llenos y alguno es nulo"
        );
        Mockito.verify(bookingRepository).save(booking.toModel());
    }
    @Test
    public void Given_A_Booking_List_When_Find_All_Is_Cast_Then_Return_Booking_List(){

        List<BookingModel> bookingList = new ArrayList<>();
        BookingModel booking = new BookingModel(1,1,null,1,null,new java.util.Date());
        bookingList.add(booking);
        Mockito.when(bookingRepository.findAll()).thenReturn(bookingList);

        List<BookingModel> response = bookingServiceImpl.findAll();

        assertEquals(1, response.size());
        Assertions.assertNotNull(response);
        Mockito.verify(bookingRepository).findAll();
    }
    @Test
    public void Given_A_List_And_A_Date_When_Find_By_Date_Is_Cast_Then_Return_Booking_List(){
        java.util.Date  date= new java.util.Date(2024-12-12);
        List<BookingModel> bookingList = new ArrayList<>();
        BookingModel booking = new BookingModel(1,1,null,1,null,date);
        bookingList.add(booking);
        Mockito.when(bookingRepository.findByDate(any(java.sql.Date.class))).thenReturn(bookingList);

        List<BookingModel> response = bookingServiceImpl.findByDate(date);

        Assertions.assertNotNull(response);
        Mockito.verify(bookingRepository).findByDate(any(java.sql.Date.class));
    }
}
