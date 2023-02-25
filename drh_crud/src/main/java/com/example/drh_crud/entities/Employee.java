package com.example.drh_crud.entities;

import com.example.drh_crud.types.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Date starting_work_date;

    @Column(unique = true)
    private String email;

    @ToString.Exclude
    @JsonIgnore
    @Embedded
    private Diplome diplome;
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    private Departement departement;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    private Project project;
}
