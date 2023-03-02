package com.stormsidali2001.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ProductResponseDto {

    private String id;

    private String name;

    private String description;

    private BigDecimal price;
}
