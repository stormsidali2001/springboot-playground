package com.example.msorder.controller;

import com.example.msorder.dto.OrderDto;
import com.example.msorder.dto.OrderResponseDto;
import com.example.msorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderDto orderDto){
        return this.orderService.placeOrder(orderDto);
    }
    @GetMapping
    public Collection<OrderResponseDto> getAll(){
        return orderService.getAll();
    }

}
