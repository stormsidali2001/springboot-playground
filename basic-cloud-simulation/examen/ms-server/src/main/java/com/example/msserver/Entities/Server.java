package com.example.msserver.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity(name="server") @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String datacenterName;

    @Embedded
    private Configuration configuration;




}
