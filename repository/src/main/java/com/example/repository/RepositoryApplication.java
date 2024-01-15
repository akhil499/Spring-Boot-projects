package com.example.repository;

import com.example.repository.model.Product;
import com.example.repository.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner {

	private ProductRepository productRepository;




	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}



	private Logger LOG =  LoggerFactory.getLogger(RepositoryApplication.class);

	@Autowired
	public void productRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product1 = new Product();
		product1.setName("Tester product");
		product1.setDescription("This is a tester product");
		product1.setCategory("TEST");
		product1.setType("GENERAL");
		product1.setPrice(0.0);

		productRepository.save(product1);

		Product product2 = new Product();
		product2.setName("Another Tester product");
		product2.setDescription("This is a tester product");
		product2.setCategory("TEST");
		product2.setType("CUSTOM");
		product2.setPrice(15.0);

		productRepository.save(product2);


		Product product3 = new Product();
		product3.setName("Tester product");
		product3.setDescription("This is a tester product");
		product3.setCategory("TEST");
		product3.setType("SPECIFIC");
		product3.setPrice(10.0);

		productRepository.save(product3);

		Product productFromRestTemplate  = restTemplate.getForObject("http://localhost:8080/api/products/c416ef56-eb04-4865-8c25-6abc75ffc24d", Product.class);

		LOG.info("Product received with rest template " + productFromRestTemplate.getCategory());
//		product toUpdate = productRepository.findByType("SPECIFIC");
//
//		if(toUpdate != null) {
//			toUpdate.setName("Updated product");
//			toUpdate.setDescription("Updated");
//
//			productRepository.save(toUpdate);
//		}

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
