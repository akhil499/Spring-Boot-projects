package com.example.repository;

import com.example.repository.model.product;
import com.example.repository.repository.ProductRepository;
import org.apache.juli.logging.Log;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner {

	private ProductRepository productRepository;

	@Autowired
	public void productRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		product product1 = new product();
		product1.setName("Tester product");
		product1.setDescription("This is a tester product");
		product1.setCategory("TEST");
		product1.setType("GENERAL");
		product1.setPrice(0.0);

		productRepository.save(product1);

		product product2 = new product();
		product2.setName("Another Tester product");
		product2.setDescription("This is a tester product");
		product2.setCategory("TEST");
		product2.setType("CUSTOM");
		product2.setPrice(15.0);

		productRepository.save(product2);


		product product3 = new product();
		product3.setName("Tester product");
		product3.setDescription("This is a tester product");
		product3.setCategory("TEST");
		product3.setType("SPECIFIC");
		product3.setPrice(10.0);

		productRepository.save(product3);

		product toUpdate = productRepository.findByType("SPECIFIC");

		if(toUpdate != null) {
			toUpdate.setName("Updated product");
			toUpdate.setDescription("Updated");

			productRepository.save(toUpdate);
		}

//		productRepository.delete(product3);
//
//		product foundProduct = productRepository.findByType("GENERAL");
//
//		if(foundProduct != null) {
//			productRepository.delete(foundProduct);
//			System.out.println("Deleted");
//		}
	}
}
