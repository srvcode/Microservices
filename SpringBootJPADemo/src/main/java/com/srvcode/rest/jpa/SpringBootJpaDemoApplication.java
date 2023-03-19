package com.srvcode.rest.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.srvcode.rest.jpa.model.Product;
import com.srvcode.rest.jpa.repository.ProductRepository;

@SpringBootApplication
public class SpringBootJpaDemoApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product("Television", "Electronics"));
		productRepository.save(new Product("Air Conditioner", "Electronics"));
		productRepository.save(new Product("Sofa", "Furniture"));
		productRepository.save(new Product("Cushions", "Home Essentials"));
		productRepository.save(new Product("Wardrobe", "Furniture"));
	}
}
