package com.example.msuser.Entities;

import com.example.msuser.Model.ServerModal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class VirtualMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Configuration configuration;

    @ManyToOne
    private User user;

    private Long serverId;

    @Transient
    private ServerModal server;
}
