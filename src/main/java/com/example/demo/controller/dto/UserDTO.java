package com.example.demo.controller.dto;

import javax.persistence.*;
import lombok.Data;
import java.util.*;

@Data @Entity @Table(name = "CLIENT")
public class UserDTO {
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