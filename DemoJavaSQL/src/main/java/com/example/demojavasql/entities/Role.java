package com.example.demojavasql.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role_name")
    private String name;

}
