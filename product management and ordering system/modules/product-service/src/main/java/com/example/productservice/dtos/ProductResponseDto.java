package com.example.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;


@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class ProductResponseDto {
    public String id;
    private String name;

    private String description;

    private BigDecimal price;
}
