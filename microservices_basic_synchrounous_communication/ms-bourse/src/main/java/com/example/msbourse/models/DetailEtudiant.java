package com.example.msbourse.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class DetailEtudiant {
    private String nom;
    private String promo;

    private Date dateInscription;

    private String nomEtablissement;
}
