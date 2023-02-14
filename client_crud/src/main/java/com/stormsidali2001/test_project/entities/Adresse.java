package com.stormsidali2001.test_project.entities;
import lombok.*;
import jakarta.persistence.*;
import java.lang.Integer;
import java.io.Serializable;

@Embeddable
@Data @AllArgsConstructor @NoArgsConstructor
public class Adresse  implements Serializable{
    
    private Integer numero;
    private String rue;
    private String codePostal;
    private String ville;

}
