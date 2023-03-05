package com.example.msuser.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity(name="utilisateur") @Data @Builder @AllArgsConstructor @NoArgsConstructor
@Table(name="utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String email;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany
    private Collection<VirtualMachine> virtualMachines;

}
