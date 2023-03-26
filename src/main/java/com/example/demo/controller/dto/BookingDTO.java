package com.example.demo.controller.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "BOOKING")
public class BookingDTO {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", nullable = false, length = 11)
    private Integer bookingId;

    @Column(name = "CLIENT_ID", length = 11)
    private Integer clientId;
    //@ForeignKey
    @Column(name = "PET_ID", length = 11)
    private Integer petId;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

}