package com.example.demojavasql.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
public class OpeningSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "address")
    private String address;
    @Column(name = "study_day")
    private LocalDate studyDay;
}
