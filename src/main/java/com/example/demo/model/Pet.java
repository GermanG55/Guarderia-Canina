package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "PET")
public class Pet {

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
    private User user;

    @Column(name = "DATE_CREATED", nullable = false, length = 100, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

}