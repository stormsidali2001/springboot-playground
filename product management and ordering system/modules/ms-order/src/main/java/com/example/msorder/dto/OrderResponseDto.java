package com.example.msorder.dto;

import com.example.msorder.Entities.OrderLine;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private Long id;

    private String orderNumber;

    private Collection<OrderLineResponse> lines;
}
