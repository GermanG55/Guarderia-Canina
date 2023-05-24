package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOKING")
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 11)
    private Integer bookingId;

    @Column(name = "CLIENT_ID", length = 11)
    private Integer clientId;
    @ManyToOne
    @JoinColumn(name="CLIENT_ID", insertable = false, updatable = false)
    private UserModel user;

    @Column(name = "PET_ID", length = 11)
    private Integer petId;
    @ManyToOne
    @JoinColumn(name="PET_ID", insertable = false, updatable = false)
    private PetModel pet;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

}
