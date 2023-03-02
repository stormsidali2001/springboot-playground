package com.stormsidali2001.productservice.service;

import com.stormsidali2001.productservice.Model.Product;
import com.stormsidali2001.productservice.Repository.ProductRepository;
import com.stormsidali2001.productservice.dto.CreateProductDto;
import com.stormsidali2001.productservice.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;
    public void createProduct(CreateProductDto productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("product {} is saved",product.getId());
    }
    public List<ProductResponseDto> getAllProduct(){
        List<Product> products =  productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }
    private ProductResponseDto mapToProductResponse(Product p){
        return ProductResponseDto.builder()
                .id(p.getId())
                .name(p.getName())
                .price(p.getPrice())
                .description(p.getDescription())
                .build();
    }
}
