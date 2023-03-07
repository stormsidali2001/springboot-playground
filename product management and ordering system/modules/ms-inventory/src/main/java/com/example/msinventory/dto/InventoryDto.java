package com.example.msinventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder @Data @NoArgsConstructor @AllArgsConstructor
public class InventoryDto {
    private Integer quantity;

    private String sku;
}
