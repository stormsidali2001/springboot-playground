package com.example.msinventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder @AllArgsConstructor @NoArgsConstructor @Data
public class InventoryResponse {
    private Long id;

    private Integer quantity;

    private String sku;
}
