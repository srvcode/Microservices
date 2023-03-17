package com.srvcode.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value="/", method= RequestMethod.GET)		// http://localhost:8080
	public String index() {
		return "this is the main page";
	}
	
	@RequestMapping(value="/welcome", method= RequestMethod.GET)	// http://localhost:8080/welcome
	public String welcome() {
		return "Welcome to Spring Boot!";
	}
	
	@RequestMapping(value="/hello", method= RequestMethod.GET)	// http://localhost:8080/hello
	public String hello() {
		return "Hello Spring Boot!";
	}
}
