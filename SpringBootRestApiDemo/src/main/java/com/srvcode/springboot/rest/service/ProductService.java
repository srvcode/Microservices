package com.srvcode.springboot.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.srvcode.springboot.rest.model.Product;

@Service
public class ProductService {

	private List<Product> products = new ArrayList<>(Arrays.asList(
			new Product("P101", "Monitor", "Electronics"),
			new Product("P102", "Blanket", "Household"),
			new Product("P103", "Laptop", "Electronics"),
			new Product("P104", "Shirt", "Fashion"),
			new Product("P105", "Pens", "School")));
	
	public List<Product> getAllProducts() {
		return products;
	}
	
	public Product getProduct(String id) {
		return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void updateProduct(String id, Product product) {
		for(int i = 0; i < products.size(); i++) {
			Product oldProduct = products.get(i);
			if(id.equalsIgnoreCase(oldProduct.getId())) {
				products.set(i, product);
				return;
			}
		}
	}
	
	public void deleteProduct(String id) {
		products.removeIf(p -> p.getId().equals(id));
	}
}
