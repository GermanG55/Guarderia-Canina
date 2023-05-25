package com.example.demo.service.impl;


import com.example.demo.infrastructura.controller.dto.UserDto;
import com.example.demo.dominio.model.UserModel;
import com.example.demo.aplicacion.service.impl.UserServiceImpl;
import com.example.demo.infrastructura.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class
UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceImpl;
    @Mock
    private UserRepository userRepository;
    private UserDto user;
    @Test
    public void Given_A_User_When_Save_User_Is_Cast_Then_Return_True(){

        user = new UserDto(1,"German","Negro Arroyo",new java.util.Date());
        Mockito.when(userRepository.save(any(UserModel.class))).thenReturn(user.toModel());

        userServiceImpl.saveUser(user.toModel());

        Mockito.verify(userRepository).save(user.toModel());
    }
    @Test
    public void Given_A_User_And_An_Illegal_Exception_When_Save_User_Is_Cast_Then_Throw_An_Illegal_Argument_Exception(){

        user = new UserDto(1,"German","Negro Arroyo",new java.util.Date());
        Mockito.when(userRepository.save(any(UserModel.class))).thenThrow(new IllegalArgumentException());

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        userServiceImpl.saveUser(user.toModel()),
                "Esperaba campos llenos y alguno es nulo"
        );

    }
    @Test
    public void Given_A_User_List_When_Find_All_Is_Cast_Then_Return_User_List(){

        List<UserModel> userList = new ArrayList<>();
        user = new UserDto(1,"German","Negro Arroyo",new java.util.Date());
        userList.add(user.toModel());
        Mockito.when(userRepository.findAll()).thenReturn(userList);

        List<UserModel> response = userServiceImpl.findAll();

        Assertions.assertNotNull(response);
        Mockito.verify(userRepository).findAll();
    }
    @Test
    public void Given_A_User_List_When_Find_Booking_By_Document_Is_Cast_Then_Return_Booking_List(){

        List<UserModel> userList = new ArrayList<>();
        user = new UserDto(1,"German","Negro Arroyo",new java.util.Date());
        userList.add(user.toModel());
        Mockito.when(userRepository.findBookingByDocument(any(Integer.class))).thenReturn(userList);

        List<UserModel> response = userServiceImpl.findBookingByDocument(1);

        Assertions.assertNotNull(response);
        Mockito.verify(userRepository).findBookingByDocument(1);
    }
    @Test
    public void Given_A_User_List_When_Find_Pets_By_Document_Is_Cast_Then_Return_Pet_List(){

        List<UserModel> userList = new ArrayList<>();
        user = new UserDto(1,"German","Negro Arroyo",new java.util.Date());
        userList.add(user.toModel());
        Mockito.when(userRepository.findPetsByDocument(any(Integer.class))).thenReturn(userList);

        List<UserModel> response = userServiceImpl.findPetsByDocument(1);

        Assertions.assertNotNull(response);
        Mockito.verify(userRepository).findPetsByDocument(1);
    }
}