package com.srvcode.userproperties.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
//all configuration properties like messages.property_name will be read.
@ConfigurationProperties("messages")	
@Data
public class MesssageProperties {

	/*
	 * Greeting message returned by the Greeting controller.
	 */
	private String greeting = "Good morning ";
	
}
