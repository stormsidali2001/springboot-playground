package com.example.msbourse.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Virement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVirement;

    private Float montant;

    @Temporal(TemporalType.DATE)
    private Date dateVirement;


    @ManyToOne @JoinColumn(name = "idEtudiant")
    Etudiant etudiant;
}
