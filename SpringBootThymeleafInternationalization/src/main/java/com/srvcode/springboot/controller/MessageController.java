package com.srvcode.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Here the value returned by the handler methods is not considered
 * to be a web response. Instead the return value of these methods is 
 * interpreted as a logical view name.
 * 
 * The Thymeleaf template engine will then map this view name to a physical view
 * which is then rendered by the browser.
 * 
 * The physical view corresponding to this logical view name whom we have placed
 * within the templates folder under src/main/resources
 */

@Controller
public class MessageController {

	@GetMapping(value="/home")
	public String index() {
		return "home";
	}
}
