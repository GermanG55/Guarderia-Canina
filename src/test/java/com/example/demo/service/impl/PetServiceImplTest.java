package com.example.demo.service.impl;

import com.example.demo.controller.dto.PetDto;

import com.example.demo.model.PetModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.PetRepository;
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
public class PetServiceImplTest {
    @InjectMocks
    private PetServiceImpl petServiceImpl;
    @Mock
    private PetRepository petRepository;
    private PetDto pet;

    @Test
    public void Given_A_Pet_When_Save_Pet_Is_Cast_Then_Pet_Is_Saved(){

        pet = new PetDto(1,"Michi",1,null,new java.util.Date());
        Mockito.when(petRepository.save(any(PetModel.class))).thenReturn(pet.toModel());
        Mockito.when(petRepository.countByClient(any(Integer.class))).thenReturn(1);

        petServiceImpl.savePet(pet.toModel());

        Mockito.verify(petRepository).save(pet.toModel());
    }
    /*@Test
    public void Given_A_Pet_When_Save_Pet_Is_Cast_And_The_Condition_Is_False_Then_Return_False(){

        pet = new PetDto(1,"Michi",1,null,new java.util.Date());
        Mockito.when(petRepository.countByClient(any(Integer.class))).thenReturn(3);

        petServiceImpl.savePet(pet.toModel());

        Mockito.verify(petRepository).countByClient(any(Integer.class));
    }*/
    @Test
    public void Given_A_Pet_And_An_Illegal_Exception_When_Save_Pet_Is_Cast_Then_Throw_An_Illegal_Argument_Exception(){

        pet = new PetDto(1,"Michi",1,null,new java.util.Date());
        Mockito.when(petRepository.save(any(PetModel.class))).thenThrow(new IllegalArgumentException());

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        petServiceImpl.savePet(pet.toModel()),
                "Esperaba campos llenos y alguno es nulo"
        );


    }
    @Test
    public void Given_A_Pet_List_When_Find_All_Is_Cast_Then_Return_Pet_List() {

        List<PetModel> petList = new ArrayList<>();
        pet = new PetDto(1, "Michi", 1, null, new java.util.Date());
        petList.add(pet.toModel());
        Mockito.when(petRepository.findAll()).thenReturn(petList);

        List<PetModel> response = petServiceImpl.findAll();

        Assertions.assertNotNull(response);
        Mockito.verify(petRepository).findAll();
    }
    @Test
    public void Given_A_List_And_An_Owner_Document_When_Find_By_Owner_Is_Cast_Then_Return_Pet_List(){

        List<PetModel> petList = new ArrayList<>();
        pet = new PetDto(1,"German",1,new UserModel(),new java.util.Date());
        petList.add(pet.toModel());
        Mockito.when(petRepository.findByOwnerDocument(1)).thenReturn(petList);

        List<PetModel> response = petServiceImpl.findByOwnerDocument(1);

        Assertions.assertNotNull(response);
        Mockito.verify(petRepository).findByOwnerDocument(1);
    }
}
