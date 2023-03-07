package com.example.productservice.service;

import com.example.productservice.Entities.Product;
import com.example.productservice.Repositories.ProductRepository;
import com.example.productservice.dtos.ProductDto;
import com.example.productservice.dtos.ProductResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void create(ProductDto product){
        Product p = Product
                .builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
        productRepository.save(p);
        log.info("product {} has been saved",p.getId());

    }

    public List<ProductResponseDto> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }
    public ProductResponseDto  mapToProductResponse(Product p){
        return ProductResponseDto.builder()
                .name(p.getName())
                .id(p.getId())
                .description(p.getDescription())
                .price(p.getPrice())
                .build();
    }

}
