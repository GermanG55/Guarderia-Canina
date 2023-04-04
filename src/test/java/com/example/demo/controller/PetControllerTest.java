package com.example.demo.controller;

import com.example.demo.model.Pet;
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

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {

    private List<Pet> petList(){
        List<Pet> petList= new ArrayList<>();
        Pet pet = new Pet();
        pet.setId(113);
        pet.setPetName("Juan");
        pet.setOwnerDocument(423);
        pet.setDateCreated(new Date());
        petList.add(pet);
        return petList;
    }

    @Mock
    PetService petService;
    @InjectMocks
    PetController petController ;

    @Test
    public void Given_All_Values_Request_When_Values_Arent_Empty_Then_Return_Existing_List_As_Not_Empty (){
        Mockito.when(petService.findAll()).thenReturn(petList());
        List<Pet> result = petController.findAll();
        assertEquals(1, result.size());
        Assertions.assertThat(result);
        Mockito.verify(petService).findAll();
    }
}
