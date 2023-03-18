package com.srvcode.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController means any value that you return from handler method is 
 * automatically considered a response body i.e., it's considered to be
 * a web response that is rendered to the user.
 * 
 * The return values from handler methods are not logical views mapped to a physical view
 * rather they are response body to be directly rendered.
 */
@RestController

@RequestMapping(value = "/organization/")
public class WebServiceController {

	@GetMapping("/info")		//http://localhost:8085/organization/info?name=abc
	public String myName(@RequestParam(defaultValue = "Mumbai") String name) {
		return "<h2> Welcome to Spring Boot at <i>" + name + " </i>! This is an HTTP GET request </h2>";
	}
	
	@GetMapping("/newInfo")		//http://localhost:8085/organization/newInfo?orgName=def
	public String myCustomizedName(@RequestParam(name="orgName" ,defaultValue = "Pune") String name) {
		return "<h2> Welcome to Spring Boot at <i>" + name + " </i>! This is an HTTP GET request </h2>";
	}
	
	@GetMapping("/info/{name}")		//http://localhost:8085/organization/info/delhi
	public String myNameUsingPathVariable(@PathVariable("name") String name) {
		return "<h2> Welcome to Spring Boot at <i>" + name + " </i>! This is an HTTP GET request </h2>";
	}
}
