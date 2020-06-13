package org.sid;

import org.sid.entity.Product;
import org.sid.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(InventoryRepository inventoryRepository, RepositoryRestConfiguration configuration) {
		return args -> {
			configuration.exposeIdsFor(Product.class);
			inventoryRepository.save(new Product(null, "Ordinateur DELL XPS", 5000));
			inventoryRepository.save(new Product(null, "Imprimante HP 300", 300));
			inventoryRepository.save(new Product(null, "Clé USB DELL", 20));
			inventoryRepository.findAll().forEach(System.out::println);
		};
	}
}
