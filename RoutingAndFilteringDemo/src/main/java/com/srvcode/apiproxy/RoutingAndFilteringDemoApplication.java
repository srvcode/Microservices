package com.srvcode.apiproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RoutingAndFilteringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutingAndFilteringDemoApplication.class, args);
	}

/*	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
	
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}*/
}
