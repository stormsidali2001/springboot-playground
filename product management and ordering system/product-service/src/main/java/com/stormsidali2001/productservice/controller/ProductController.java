package com.stormsidali2001.productservice.controller;

import com.stormsidali2001.productservice.dto.CreateProductDto;
import com.stormsidali2001.productservice.dto.ProductResponseDto;
import com.stormsidali2001.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody() CreateProductDto product){
        this.productService.createProduct(product);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProduct(){
        return  this.productService.getAllProduct();
    }
}
