package com.example.msorder.dto;

import com.example.msorder.Entities.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class OrderDto {
    private  Collection<OrderLineDto> lines;
}
