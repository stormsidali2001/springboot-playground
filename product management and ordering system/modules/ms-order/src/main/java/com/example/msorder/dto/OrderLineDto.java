package com.example.msorder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Collection;

@Builder @AllArgsConstructor @NoArgsConstructor @Data
public class OrderLineDto {
    private String sku;
    private BigDecimal price;

    private Integer quantity;
}
