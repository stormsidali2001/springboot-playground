package com.example.msuser.Entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable @NoArgsConstructor @Builder @AllArgsConstructor @Data
public class Configuration implements Serializable {
    private Long cpu;

    private Long ram;

    private Long diskSize;

}
