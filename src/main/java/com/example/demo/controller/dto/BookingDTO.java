package com.example.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@Data
@Table(name = "BOOKING")
public class BookingDTO {

    @Id
    @Column(name = "ID", nullable = false, length = 10)
    private Integer booking_id;

    @Column(name = "CLIENT_ID", nullable = false, length = 10)
    private Integer client_id;
    //@ForeignKey
    @Column(name = "PET_ID", nullable = false, length = 10)
    private Integer pet_id;

    @Column(name = "DATE", nullable = false, length = 50)
    @Temporal(TemporalType.DATE)
    private Date date;

}