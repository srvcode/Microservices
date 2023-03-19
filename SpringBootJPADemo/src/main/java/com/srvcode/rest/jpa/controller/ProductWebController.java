package com.srvcode.rest.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.srvcode.rest.jpa.model.Product;

@Controller
public class ProductWebController {

	@Autowired
	private ProductController productController;

	@GetMapping("/webUI")	//http://localhost:8085/webUI
	public String getAllProduct(Model model) {
		
		List<Product> productsList = productController.getAllProducts();
		model.addAttribute("products", productsList);
		return "list_products";
	}
	
	@GetMapping("/new_product")	//http://localhost:8085/new_product
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	
	@PostMapping(value="/save_new")
	public String saveNewProduct(@ModelAttribute("product") Product product) {
		productController.addProduct(product);
		return "redirect:/webUI";
	}
	
	@GetMapping("/update_product/{pId}")
	public String editForm(@PathVariable(name="pId") Long id, Model model) {
		model.addAttribute("product", productController.getProductById(id));
		return "update_product";
	}
	
	@PostMapping("/save_update")
	public String saveUpdatedProduct(@ModelAttribute("product") Product product) {
		productController.updateProduct(product.getId(), product);
		return "redirect:/webUI";
	}
	
	@GetMapping("/delete_product/{pId}")
	public String deleteProduct(@PathVariable(name="pId") Long id, Model model) {
		model.addAttribute("product", productController.getProductById(id));
		return "delete_product";
	}
	
	@PostMapping("/save_delete")
	public String saveDeleteProduct(@ModelAttribute("product") Product product) {
		productController.deleteProduct(product.getId());
		return "redirect:/webUI";
	}
}
