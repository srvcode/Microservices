package com.srvcode.rest.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srvcode.rest.cache.exception.ProductNotFoundException;
import com.srvcode.rest.cache.model.Product;
import com.srvcode.rest.cache.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{pId}")
	public Product getProductById(@PathVariable("pId") Long id) {
		return productService.getProduct(id).orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@PutMapping("/products/{pId}")
	public void updateProduct(@PathVariable("pId") Long id, @RequestBody Product product) {
		productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/products/{pId}")
	public void deleteProduct(@PathVariable("pId") Long id) {
		productService.deleteProduct(id);
	}
}
