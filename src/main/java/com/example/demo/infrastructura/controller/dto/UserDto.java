package com.example.demo.infrastructura.controller.dto;


import com.example.demo.dominio.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer document;
    private String name;
    private String address;
    private Date dateCreated;

    public UserModel toModel(){
        return new UserModel(this.document, this.name,this.address,this.dateCreated);
    }
}
