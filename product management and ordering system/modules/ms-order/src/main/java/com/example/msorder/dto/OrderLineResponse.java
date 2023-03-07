package com.example.msorder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder @Data @NoArgsConstructor @AllArgsConstructor
public class OrderLineResponse {
    private Long id;
    private String sku;
    private BigDecimal price;
    private Integer quantity;
}
