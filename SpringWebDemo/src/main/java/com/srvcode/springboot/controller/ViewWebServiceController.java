package com.srvcode.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * The use of the @Controller annotation rather than @RestController tells
 * Spring that the response from the handler methods should be treated as a logical view by default.
 * Unless the handler method has been explicitly tagged using the @ResponseBody annotation.
 * 
 */

@Controller
@RequestMapping(value="organization")
public class ViewWebServiceController {

	/*
	 * This handler method response will be treated as a logical view that will be mapped to
	 * a physical view name by the thymeleaf template engine.
	 */
	
	@GetMapping("/")			// http://localhost:8085/organization/
	public String formPage() {
		return "editName";
	}
	
	/*
	 * This handler method response will be rendered as a web response (not logical view name)
	 */
	
	@GetMapping("/viewInfo")	//http://localhost:8085/organization/viewInfo?name=abc
	@ResponseBody
	public String myViewInfo(@RequestParam(defaultValue="Chennai") String name) {
		return "<h2> Welcome to Spring Boot at <i>" + name + " </i>! This is an HTTP GET request </h2>";
	}
}
