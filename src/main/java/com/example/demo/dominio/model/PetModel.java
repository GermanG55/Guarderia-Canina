package com.example.demo.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PET")
public class PetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 10)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String petName;

    @Column(name = "CLIENT", nullable = false, length = 50)
    private Integer ownerDocument;
    @ManyToOne
    @JoinColumn(name="CLIENT", insertable = false, updatable = false)
    private UserModel user;

    @Column(name = "DATE_CREATED", nullable = false, length = 100, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

}