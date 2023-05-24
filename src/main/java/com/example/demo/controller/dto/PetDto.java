package com.example.demo.controller.dto;

import com.example.demo.model.PetModel;
import com.example.demo.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
    private Integer Id;
    private String petName;
    private Integer ownerDocument;
    private UserModel user;
    private Date date_created;
    public PetModel toModel(){
        return new PetModel(this.Id, this.petName,this.ownerDocument,this.user,this.date_created);
    }
}
