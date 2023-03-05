package com.example.msuser.Model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class ConfigurationModel  {
    private Long cpu;

    private Long ram;

    private Long diskSize;

}

