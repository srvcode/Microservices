package com.srvcode.userproperties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * The Model holds the data that we'll pass from the controller to our view.
 */

@Controller
public class GreetingController {
	
	@Autowired
	private MesssageProperties properties;
	
	@GetMapping("/greeting")			// http://localhost:8085/greeting?name=shivam
	public String greeting(@RequestParam String name, Model model) {
	
		String message = properties.getGreeting() + name;
		model.addAttribute("greetingMessage", message);
		return "homePage";
	}

}
