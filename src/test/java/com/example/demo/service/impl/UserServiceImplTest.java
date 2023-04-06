package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
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
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceImpl;
    @Mock
    private UserRepository userRepository;
    @Test
    public void Given_A_User_When_Save_User_Is_Cast_Then_Return_True(){
        //arrange
        User user = new User(1,"German","Negro Arroyo",new java.util.Date());
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
        //act
        Boolean response = userServiceImpl.saveUser(user);
        //assert
        Assertions.assertNotNull(response);
        Assertions.assertEquals(true,response);
        Mockito.verify(userRepository).save(any(User.class));
    }
    @Test
    public void Given_A_User_And_An_Illegal_Exception_When_Save_User_Is_Cast_Then_Return_False(){
        //arrange
        User user = new User(1,"German","Negro Arroyo",new java.util.Date());
        Mockito.when(userRepository.save(any(User.class))).thenThrow(new IllegalArgumentException());
        //act
        Boolean response = userServiceImpl.saveUser(user);
        //assert
        Assertions.assertNotNull(response);
        Assertions.assertEquals(false,response);
    }
    @Test
    public void Given_A_User_List_When_Find_All_Is_Cast_Then_Return_User_List(){
        //arrange
        List<User> userList = new ArrayList<>();
        User user = new User(1,"German","Negro Arroyo",new java.util.Date());
        userList.add(user);
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        //act
        List<User> response = userServiceImpl.findAll();
        //assert
        Assertions.assertNotNull(response);
        Mockito.verify(userRepository).findAll();
    }

}
