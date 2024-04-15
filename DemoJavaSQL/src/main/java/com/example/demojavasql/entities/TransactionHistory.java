package com.example.demojavasql.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
public class TransactionHistory {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "registration")
    private String registration;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "status")
    private String status;
}
