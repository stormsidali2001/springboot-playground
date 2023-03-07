package com.example.msinventory.service;

import com.example.msinventory.dto.InStockResponse;
import com.example.msinventory.dto.InventoryDto;
import com.example.msinventory.dto.InventoryResponse;
import com.example.msinventory.entities.Inventory;
import com.example.msinventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public void create(InventoryDto inventoryDto){
        inventoryRepository.save(
                Inventory.builder()
                        .sku(inventoryDto.getSku())
                        .quantity(inventoryDto.getQuantity())
                        .build()
        );
    }

    public Collection<InventoryResponse> getAll(){
        return inventoryRepository.findAll().stream().map(this::mapInventoryToDto).toList();
    }
    public InventoryResponse mapInventoryToDto(Inventory inventory){
        return InventoryResponse.builder()
                .quantity(inventory.getQuantity())
                .sku(inventory.getSku())
                .id(inventory.getId())
                .build();
    }

    @Transactional(readOnly = true)
    public List<InStockResponse> isInStock(List<String> skus){
        return  inventoryRepository.findBySkuIn(skus).stream().map(this::mapToInStock).toList();
    }
    public InStockResponse mapToInStock(Inventory inv){
        return InStockResponse.builder()
                .sku(inv.getSku())
                .isInStock(inv.getQuantity() > 0)
                .build();
    }

}
