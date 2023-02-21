package com.example.msscolarity.entities;

import com.example.msscolarity.models.Formation;
import com.example.msscolarity.models.Virement;
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

    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    @ManyToOne
    private Etablissement etablissement;

    private Long idFormation;

    @Transient()
    private Formation formation;

    @Transient()
    private Virement virement;



}
