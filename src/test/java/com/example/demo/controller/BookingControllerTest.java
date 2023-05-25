package com.example.demo.controller;


import com.example.demo.infrastructura.controller.BookingController;
import com.example.demo.infrastructura.controller.dto.BookingDto;
import com.example.demo.dominio.model.BookingModel;
import com.example.demo.aplicacion.service.BookingService;
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
    private BookingDto booking;

    private List<BookingModel> bookingList = new ArrayList<>();

    @Test
    public void Given_A_List_Of_Two_Items_When_Find_All_Is_Cast_Then_Verify_It_Is_A_Two_Item_List () {
        booking = new BookingDto(1, 1, null, 1, null, new Date());
        bookingList.add(booking.toModel());
        booking = new BookingDto(2, 2, null, 2, null, new Date());
        bookingList.add(booking.toModel());
        Mockito.when(bookingService.findAll()).thenReturn(bookingList);

        List<BookingModel> bookingListResponse = bookingController.findAll();

        assertNotNull(bookingListResponse.size());
        assertEquals(2, bookingListResponse.size());
        Mockito.verify(bookingService).findAll();
    }

    @Test
    public void Given_A_New_Booking_Info_When_New_Booking_Is_Registered_Then_Save_Booking (){
        booking = new BookingDto(1,1,null,1,null,new Date());
        Mockito.doNothing().when(bookingService).saveBooking(booking.toModel());

        bookingController.saveBooking(booking);

        Mockito.verify(bookingService).saveBooking(booking.toModel());
    }

    @Test
    public void Given_Search_By_Date_When_New_Search_Done_Then_Return_List_Size_As_One (){
        booking = new BookingDto(1,1,null,1,null,new Date());
        bookingList.add(booking.toModel());
        Mockito.when(bookingService.findByDate(new Date(23-23-22))).thenReturn(bookingList);
        List<BookingModel> bookingListResponse = bookingController.findByDate(new Date(23-23-22));
        assertEquals(1, bookingListResponse.size());
        Mockito.verify(bookingService).findByDate(new Date(23-23-22));
    }

    @Test
    public void Given_Search_Values_Request_By_Date_When_Values_Arent_Null_Then_Return_Size_Existent (){
        booking = new BookingDto(1,1,null,1,null,new Date());
        bookingList.add(booking.toModel());
        Mockito.when(bookingService.findByDate(new Date(23-23-22))).thenReturn(bookingList);
        List<BookingModel> bookingListResponse = bookingController.findByDate(new Date(23-23-22));
        assertNotNull(bookingListResponse);
        Mockito.verify(bookingService).findByDate(new Date(23-23-22));
    }

}
