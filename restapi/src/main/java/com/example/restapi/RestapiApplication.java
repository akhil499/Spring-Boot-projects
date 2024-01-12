package com.example.restapi;

import com.example.restapi.model.Product;
import com.example.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {

	private ProductRepository productRepository;

	@Autowired
	public void productRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product testprod = new Product();

		testprod.setName("Test prod");
		testprod.setDescription("Sample description");
		testprod.setCategory("SPECIAL");
		testprod.setType("CUSTOM");

		productRepository.save(testprod);
	}
}
