package com.example.demojavasql.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "course_name")
    private String name;
    private LocalDate timeLine;
    private String description;
    private BigDecimal price;
    @Column(name = "type_course")
    private String typeCourse;
    private int vote;
}
