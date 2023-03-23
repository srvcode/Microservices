package com.srvcode.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

	/*
	 * Need this bean in order to compare user entered password
	 * & our encrypted password.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * Need this bean in order to specify the store for the users
	 * who can access our application.
	 * 
	 * The userDetailsService() method will access the user's store
	 * in order to look for a particular user.
	 * Our users can be stored in any kind of database.
	 * Here we're using In memory store.
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("loonyuser")
				.password("$2a$10$nBIb9HWMo64LjrncfbIwhud82K4EyUoYBEpwA4hgNIeus6t7lXPse").roles("USER").build();
		UserDetails admin = User.withUsername("loonyadmin")
				.password("$2a$10$yWQYUaAVUgOd7QvQAl4vPufCo7UPmWRIDBXnzk1Z7/pgZBSkWHWGi").roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	/*
	 * Need this bean to specify what URL paths in our application should
	 * be secured & which URLs are freely available without the users having to log in.
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		/*
		 * 1. authorizeRequests().antMatchers("/").permitAll()
		 * 	>  this line means any request to the root of our web application
		 * 		should be permitted to all users without login.
		 * 
		 * 2. .antMatchers("/admin").hasRole("ADMIN")
		 *  > Any request made to the /admin path requires the user to logged in
		 *  	as an administrator of our website with the ADMIN role.
		 *  
		 * 3 .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
		 *  > For all other requests, the requests have to be authenticated & have to be
		 *  	behind a login page. So, formLogin() essentially allows us to configure
		 *  	the login page with path /login. PermitAll() here means all users are allowed to
		 *  	access login & logout pages.
		 */
		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout().permitAll();
		return http.build();
	}
}
