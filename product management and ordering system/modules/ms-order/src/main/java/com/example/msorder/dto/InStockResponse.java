package com.example.msorder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @AllArgsConstructor @NoArgsConstructor @Data
public class InStockResponse {
    private String sku;

    private Boolean isInStock;

}
