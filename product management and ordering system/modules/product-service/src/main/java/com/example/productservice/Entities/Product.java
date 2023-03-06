package com.example.productservice.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.BigInteger;

@Document(value="Document") @Builder @Data @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id
    public String id;
    private String name;

    private String description;

    private BigDecimal price;

}
