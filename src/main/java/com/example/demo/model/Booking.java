package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, length = 11)
    private Integer bookingId;

    @Column(name = "CLIENT_ID", length = 11, insertable = false, updatable = false)
    private Integer clientId;
    @ManyToOne
    @JoinColumn(name="CLIENT_ID")
    private User user;

    @Column(name = "PET_ID", length = 11, insertable = false, updatable = false)
    private Integer petId;
    @ManyToOne
    @JoinColumn(name="PET_ID")
    private Pet pet;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

}