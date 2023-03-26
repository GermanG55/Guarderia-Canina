package com.example.demo.controller.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "PET")
public class PetDTO {

    @Id
    @Column(name = "ID", nullable = false, length = 10)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String petName;

    @Column(name = "CLIENT", nullable = false, length = 50)
    private String ownerDocument;
    @ManyToOne
    @JoinColumn(name="CLIENT", insertable = false, updatable = false)
    private UserDTO userDTO;

    @Column(name = "DATE_CREATED", nullable = false, length = 100, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

}
