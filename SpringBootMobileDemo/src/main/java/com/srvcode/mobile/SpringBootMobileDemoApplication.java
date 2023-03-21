package com.srvcode.mobile;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SpringBootMobileDemoApplication implements ApplicationRunner {

	private static final String ACCOUNT_SID = "";
	private static final String AUTH_ID = "";
	public static final String TWILIO_NUMBER = "";
	public static final String USER_NUMBER = "";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMobileDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Message.creator(new PhoneNumber(USER_NUMBER), new PhoneNumber(TWILIO_NUMBER), "Welcome to Spring Boot!")
				.create();
		System.out.println("Sending message....");
		
		Call.creator(new PhoneNumber(USER_NUMBER), new PhoneNumber(TWILIO_NUMBER), 
				new URI("https://demo.twilio.com/welcome/voice/voice.xml")).create();
		System.out.println("Calling....!");
	}

}
