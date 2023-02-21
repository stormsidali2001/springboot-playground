package com.example.msbourse.entities;

import com.example.msbourse.models.DetailEtudiant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "etudiant")
public class Etudiant {
    @Id
    private Long idEtudiant;

    private Long nCompteCcp;

    private Float sallaireParent;

    private Boolean situationImpos;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "etudiant")
    Collection<Virement> virements;

    @Transient()
    DetailEtudiant detailEtudiant;

}
