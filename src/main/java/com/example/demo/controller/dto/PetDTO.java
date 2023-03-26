package com.example.demo.controller.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Pets")
public class PetDTO {

    @Id
    @Column(name = "ID", nullable = false, length = 10)
    private Integer owner_document;

    @Column(name = "NAME", nullable = false, length = 50)
    private String pet_name;

    @Column(name = "CLIENT", nullable = false, length = 50)
    private String owner_name;

    @Column(name = "DATE_CREATED", nullable = false, length = 100, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date date_created;

}
