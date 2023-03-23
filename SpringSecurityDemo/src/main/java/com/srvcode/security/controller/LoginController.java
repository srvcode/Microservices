package com.srvcode.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String getWelcomPage() {
		return "welcome";
	}
	
	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/admin")
	public String getAdminPage() {
		return "admin";
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
}
