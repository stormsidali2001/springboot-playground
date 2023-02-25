package com.example.msscolarity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.Date;

@Entity @Table(name="etablissement") @Data @NoArgsConstructor @AllArgsConstructor
public class Etablissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtablissement;

    private String nom;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "etablissement")
    private Collection<Etudiant> etudiants;
}
