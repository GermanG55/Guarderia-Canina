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
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 11)
    private Integer bookingId;

    @Column(name = "CLIENT_ID", length = 11)
    private Integer clientId;
    @ManyToOne
    @JoinColumn(name="CLIENT_ID", insertable = false, updatable = false)
    private User user;

    @Column(name = "PET_ID", length = 11)
    private Integer petId;
    @ManyToOne
    @JoinColumn(name="PET_ID", insertable = false, updatable = false)
    private Pet pet;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

}