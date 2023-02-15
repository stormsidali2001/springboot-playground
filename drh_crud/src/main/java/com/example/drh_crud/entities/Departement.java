package com.example.drh_crud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@Entity  @NoArgsConstructor @AllArgsConstructor @Table(name ="departement") @Data
public class Departement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false,length = 20)
    private String name;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "departement")
    private Collection<Employee> employees;


}
