package com.example.msscolarity.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String nom;

    private String promo;

    @Temporal(TemporalType.DATE)
    private Date dateN;

    @ManyToOne
    private Etablissement etablissement;

    private Long idFormation;

}
