package com.example.msorder.service;

import com.example.msorder.Entities.Order;
import com.example.msorder.Entities.OrderLine;
import com.example.msorder.dto.*;
import com.example.msorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient webClient;

    @Transactional
    public String placeOrder(OrderDto orderDto){
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .lines(
                        orderDto.getLines().stream().map(this::mapOrderLineDtoToOrderLine).toList()
                )
                .build();
        orderRepository.save(order);

       List<String> skus = order.getLines().stream().map(OrderLine::getSku).toList();
        InStockResponse[] inventoryResponse =  webClient.get()
                .uri("http://ms-inventory/api/inventory/is-in-stock",uriBuilder->uriBuilder.queryParam("skus",skus).build())
                .retrieve()
                .bodyToMono(InStockResponse[].class) //the response is a boolean type
                .block(); //to make it sync (by default its async)
        if(inventoryResponse.length != skus.size())  throw new IllegalArgumentException("wrong skus");
        System.out.println("inventory response " + inventoryResponse.length);
        boolean allInStock = Arrays.stream(inventoryResponse).allMatch(InStockResponse::getIsInStock);
        if(!allInStock) throw new IllegalArgumentException("some products are not in stock");
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
