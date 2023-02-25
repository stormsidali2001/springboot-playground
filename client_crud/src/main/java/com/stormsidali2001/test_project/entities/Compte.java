package com.stormsidali2001.test_project.entities;
import jakarta.persistence.*; 
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String password;
    
    private String login;


    private Date dateCreation;

    
    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnore()
    Client client;

}
