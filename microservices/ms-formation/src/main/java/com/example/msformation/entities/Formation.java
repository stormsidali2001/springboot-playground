package com.example.msformation.entities;

import com.example.msformation.model.Etudiant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormation;
    private String nom;
    private Integer duree;

    @Transient
    private Collection<Etudiant> etudiants;
}
