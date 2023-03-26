package com.example.demo.controller.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "BOOKING")
public class BookingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, length = 11)
    private Integer bookingId;

    @Column(name = "CLIENT_ID", length = 11, insertable = false, updatable = false)
    private Integer clientId;
    @ManyToOne
    @JoinColumn(name="CLIENT_ID")
    private UserDTO userDTO;

    @Column(name = "PET_ID", length = 11, insertable = false, updatable = false)
    private Integer petId;
    @ManyToOne
    @JoinColumn(name="PET_ID")
    private PetDTO petDTO;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

}