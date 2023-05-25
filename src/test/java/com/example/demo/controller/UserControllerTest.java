package com.example.demo.controller;

import com.example.demo.infrastructura.controller.UserController;
import com.example.demo.infrastructura.controller.dto.UserDto;
import com.example.demo.dominio.model.UserModel;
import com.example.demo.aplicacion.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    UserService userService;
    @InjectMocks
    UserController userController ;
    private UserDto user;

    private List<UserModel> userList= new ArrayList<>();

    @Test
    public void Given_All_Values_Request_When_Values_Arent_Empty_Then_Return_Existing_List_As_Not_Empty (){
        user = new UserDto(1,"Daniel","Chilacos 34-100",new Date());
        userList.add(user.toModel());

        Mockito.when(userService.findAll()).thenReturn(userList);

        List<UserModel> result = userController.findAll();

        assertEquals(1, result.size());
        Mockito.verify(userService).findAll();
    }

    @Test
    public void Given_Saved_User_When_New_User_Registered_Then_Return_Boolean_True (){
        user = new UserDto(1,"Daniel","Chilacos 34-100",new Date());
        userList.add(user.toModel());

        userController.saveUser(user);

        Mockito.verify(userService).saveUser(user.toModel());
    }
    @Test
    public void Given_Search_Booking_By_Document_When_New_Search_Done_Then_Return_List_Size_As_One (){
        user = new UserDto(1,"Daniel","Chilacos 34-100",new Date());
        userList.add(user.toModel());
        Mockito.when(userService.findBookingByDocument(1)).thenReturn(userList);

        List<UserModel> result = userController.findBookingByDocument(1);

        assertEquals(1, result.size());
        Mockito.verify(userService).findBookingByDocument(1);
    }

    @Test
    public void Given_2_Users_When_Search_By_Document_Is_Cast_Then_Return_List_Size_As_One (){
        user = new UserDto(1,"Daniel","Chilacos 34-100",new Date());
        userList.add(user.toModel());
        Mockito.when(userService.findPetsByDocument(1)).thenReturn(userList);

        List<UserModel> result = userController.findPetsByDocument(1);

        assertEquals(1, result.size());
        Mockito.verify(userService).findPetsByDocument(1);
    }

}