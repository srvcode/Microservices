package com.srvcode.rest.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.srvcode.rest.cache.model.Product;
import com.srvcode.rest.cache.repository.ProductRepository;

@SpringBootApplication
@EnableCaching
public class SpringBootCacheDemoApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCacheDemoApplication.class, args);
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
