package com.example.drh_crud.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Data @Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false ,length = 20)
    private String name;

    private Date startRealisationDate;
    private Date endRealisationDate;

    @OneToMany(mappedBy = "project")
    private Collection<Employee> employees;
}
