package com.srvcode.mail.interceptor.model;

import lombok.Data;

@Data
public class Book {

	private Integer id;
	private String name;
	private String authorName;

	public Book() {}

	public Book(Integer id, String name, String authorName) {
		this.id = id;
		this.name = name;
		this.authorName = authorName;
	}
	
}
