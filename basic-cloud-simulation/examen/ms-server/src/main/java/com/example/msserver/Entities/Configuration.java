package com.example.msserver.Entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Configuration  implements Serializable {
    private Long cpu;

    private Long ram;

    private Long diskSize;

}
