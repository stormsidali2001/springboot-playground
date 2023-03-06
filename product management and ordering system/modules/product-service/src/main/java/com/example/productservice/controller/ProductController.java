package com.example.productservice.controller;

import com.example.productservice.dtos.ProductDto;
import com.example.productservice.dtos.ProductResponseDto;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping()
    public void create(ProductDto product){
    this.productService.create(product);
  }

  @GetMapping
  public List<ProductResponseDto> getAll(){
    return this.productService.getAllProducts();
  }
}
