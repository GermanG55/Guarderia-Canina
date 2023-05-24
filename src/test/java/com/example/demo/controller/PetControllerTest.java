package com.example.demo.controller;

import com.example.demo.controller.dto.PetDto;
import com.example.demo.controller.dto.UserDto;
import com.example.demo.model.PetModel;
import com.example.demo.service.PetService;
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
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {
    @Mock
    PetService petService;
    @InjectMocks
    PetController petController;
    private PetDto pet;
    private List<PetModel> petList = new ArrayList<>();
    @Test
    public void Given_All_Values_Request_When_Values_Arent_Empty_Then_Return_Existing_List_As_Not_Empty () {
        pet = new PetDto(1, "German", 432, null, new Date());
        petList.add(pet.toModel());
        Mockito.when(petService.findAll()).thenReturn(petList);

        petList = petController.findAll();

        assertEquals(1, petList.size());
        Mockito.verify(petService).findAll();
    }

    @Test
    public void Given_All_Values_Request_When_Values_Arent_Null_Then_Return_Size_Existent (){
        pet = new PetDto(1, "German", 1, null, new Date());
        petList.add(pet.toModel());
        pet = new PetDto(2, "German", 2, null, new Date());
        petList.add(pet.toModel());
        Mockito.when(petService.findAll()).thenReturn(petList);

        List<PetModel> result = petController.findAll();

        assertNotNull(result.size());
        assertEquals(2,result.size());
        Mockito.verify(petService).findAll();
    }

    @Test
    public void Given_A_New_Pet_Info_When_New_Pet_Is_Registered_Then_Save_Pet (){
        pet = new PetDto(563,"German",432,null,new Date());
        //Mockito.when(petService.savePet(any(PetModel.class))).thenReturn(pet.toModel());
        petController.savePet(pet);

        Mockito.verify(petService).savePet(pet.toModel());
    }

    @Test
    public void Given_A_Pet_When_Search_By_Document_Is_Cast_Then_Return_List_Size_Is_One (){
        pet = new PetDto(1,"German",1,null,new Date());
        petList.add(pet.toModel());
        Mockito.when(petService.findByOwnerDocument(1)).thenReturn(petList);
        List<PetModel> result = petController.findByOwnerDocument(1);
        assertEquals(1, result.size());
        Assertions.assertThat(result);
        Mockito.verify(petService).findByOwnerDocument(1);
    }



}
