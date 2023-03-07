package com.example.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder @Data @NoArgsConstructor @AllArgsConstructor
public class ProductDto {
    private String name;

    private String description;

    private BigDecimal price;
}
