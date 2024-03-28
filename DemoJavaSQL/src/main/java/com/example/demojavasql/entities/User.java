package com.example.demojavasql.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String email;
    private String accountBankId;


    @Column(name = "role_id")
    private int roleId;

}
