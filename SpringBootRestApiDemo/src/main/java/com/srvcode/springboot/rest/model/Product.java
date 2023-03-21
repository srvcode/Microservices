package com.srvcode.springboot.rest.model;

import lombok.Data;

@Data
public class Product {

	private String id;
	private String name;
	private String category;

	public Product() {}

	public Product(String id, String name, String category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
}
