package com.example.demojavasql.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class AccountBanking {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "account_name")
    private String nameBank;
    @Column(name = "account_numer")
    private BigDecimal accountNum;
}
