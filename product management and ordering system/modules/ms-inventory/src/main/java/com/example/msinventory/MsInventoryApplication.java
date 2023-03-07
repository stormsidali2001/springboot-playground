package com.example.msinventory;

import com.example.msinventory.entities.Inventory;
import com.example.msinventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsInventoryApplication implements CommandLineRunner {
	@Autowired
	private InventoryRepository inventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(MsInventoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		inventoryRepository.save(
				Inventory.builder()
						.quantity(200)
						.sku("dsaklafkafs")
				.build()
	);
		inventoryRepository.save(
				Inventory.builder()
						.quantity(5)
						.sku("asjaskfj")
						.build()
		);

	}
}
