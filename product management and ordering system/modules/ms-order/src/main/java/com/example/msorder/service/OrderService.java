package com.example.msorder.service;

import com.example.msorder.Entities.Order;
import com.example.msorder.Entities.OrderLine;
import com.example.msorder.dto.OrderDto;
import com.example.msorder.dto.OrderLineDto;
import com.example.msorder.dto.OrderLineResponse;
import com.example.msorder.dto.OrderResponseDto;
import com.example.msorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public String placeOrder(OrderDto orderDto){
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .lines(
                        orderDto.getLines().stream().map(this::mapOrderLineDtoToOrderLine).toList()
                )
                .build();
        orderRepository.save(order);
        return "order placed succesfully";
    }
    public OrderLine mapOrderLineDtoToOrderLine(OrderLineDto orderLineDto){
        return OrderLine.builder()
                .price(orderLineDto.getPrice())
                .quantity(orderLineDto.getQuantity())
                .sku(orderLineDto.getSku())
                .build();
    }
    public Collection<OrderResponseDto> getAll(){
        return orderRepository.findAll().stream().map(this::mapOrderToOrderResponse).toList();
    }

    public OrderResponseDto mapOrderToOrderResponse(Order order){
        return  OrderResponseDto.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .lines(order.getLines().stream().map(this::mapOrderLineToOrderLineResponse).toList())
                .build();
    }

    public OrderLineResponse mapOrderLineToOrderLineResponse(OrderLine orderLine){
            return OrderLineResponse.builder()
                    .id(orderLine.getId())
                    .sku(orderLine.getSku())
                    .quantity(orderLine.getQuantity())
                    .price(orderLine.getPrice())
                    .build();
    }

}
