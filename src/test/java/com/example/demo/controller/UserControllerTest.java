package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private List<User> userList(){
        List<User> userList= new ArrayList<>();
        User user = new User();
        user.setDocument(621);
        user.setName("Daniel");
        user.setAddress("Chilacos 34-100");
        user.setDateCreated(new Date());;
        userList.add(user);
        return userList;
    }

    @Mock
    UserService userService;
    @InjectMocks
    UserController userController ;

    @Test
    public void Given_All_Values_Request_When_Values_Arent_Empty_Then_Return_Existing_List_As_Not_Empty (){
        Mockito.when(userService.findAll()).thenReturn(userList());
        List<User> result = userController.findAll();
        assertEquals(1, result.size());
        Assertions.assertThat(result);
        Mockito.verify(userService).findAll();
    }
}
