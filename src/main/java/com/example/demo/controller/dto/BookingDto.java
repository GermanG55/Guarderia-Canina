package com.example.demo.controller.dto;


import com.example.demo.model.BookingModel;
import com.example.demo.model.PetModel;
import com.example.demo.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private Integer bookingId;

    private Integer clientId;

    private UserModel user;

    private Integer petId;

    private PetModel pet;

    private Date date;
    public BookingModel toModel(){
        return new BookingModel(this.bookingId, this.clientId,this.user,this.petId,this.pet,this.date);
    }
}
