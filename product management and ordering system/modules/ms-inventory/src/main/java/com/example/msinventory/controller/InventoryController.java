package com.example.msinventory.controller;

import com.example.msinventory.dto.InventoryDto;
import com.example.msinventory.dto.InventoryResponse;
import com.example.msinventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/inventories")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public void create(@RequestBody  InventoryDto inventoryDto){
        this.inventoryService.create(inventoryDto);
    }
    @GetMapping
    public Collection<InventoryResponse> getAll(){
        return this.inventoryService.getAll();
    }

    @GetMapping("is-in-stock/{sku}")
    public boolean isInStock(@PathVariable("sku") String sku){
        return this.inventoryService.isInStock(sku);
    }
}