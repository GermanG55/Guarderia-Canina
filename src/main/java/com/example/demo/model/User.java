package com.example.demo.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENT")
public class User {
    @Id
    @Column(name = "DOCUMENT", nullable = false, length = 11)
    private Integer document;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "ADDRESS", nullable = false, length = 200)
    private String address;

    @Column(name = "DATE_CREATED", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
}