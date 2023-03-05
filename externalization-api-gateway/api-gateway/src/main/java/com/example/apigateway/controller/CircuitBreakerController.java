package com.example.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
    @GetMapping("defaultFormation")
    public String defaultFormation(){
        return "defaullllllllllllllllt formation";
    }
}
