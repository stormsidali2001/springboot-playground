package com.example.msinventory.repository;

import com.example.msinventory.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository  extends JpaRepository<Inventory,Long> {
    public List<Inventory> findBySkuIn(List<String> skus);
}
