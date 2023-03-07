package com.example.msinventory.service;

import com.example.msinventory.dto.InventoryDto;
import com.example.msinventory.dto.InventoryResponse;
import com.example.msinventory.entities.Inventory;
import com.example.msinventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

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
    public boolean isInStock(String sku){
        return  inventoryRepository.findBySku(sku).isPresent();
    }

}
