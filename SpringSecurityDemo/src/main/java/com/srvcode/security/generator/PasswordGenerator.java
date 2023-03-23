package com.srvcode.security.generator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 * Setting up in-memory users, 
 * We can delete this file once we have our encoder password printed on console.
 */

public class PasswordGenerator {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String userPassword = "loonycorn123";
		String encodedUserPassword = encoder.encode(userPassword);
		
		System.out.println("User password: " + encodedUserPassword);
		
		String adminPassword = "loonycorn456";
		String encodedAdminPassword = encoder.encode(adminPassword);
		
		System.out.println("Admin password: " + encodedAdminPassword);
	}
}
