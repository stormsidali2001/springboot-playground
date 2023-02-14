package com.stormsidali2001.test_project.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToOne;
import java.util.Collection;



import lombok.*;

import com.stormsidali2001.test_project.types.Civility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stormsidali2001.test_project.entities.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(nullable = false , length =30)
    private String nom;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Civility sexe; 

    
    @OneToOne(mappedBy = "client")
    @JsonIgnore()
    ClientDetails clientDetails;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore()
    Collection<Compte> comptes;

    @Embedded
    private Adresse addrese;

    
}
