package com.srvcode.mail.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Configuration
public class MailController implements CommandLineRunner {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void run(String... args) throws MessagingException, IOException {
		System.out.println("Sending mail...");
		sendEmail();
		sendEmailWithAttachment();
		System.out.println("Done");
	}

	private void sendEmailWithAttachment() throws MessagingException {
		System.out.println("Mail with attachement sending....");
		MimeMessage mimeMsg = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMsgHelper = new MimeMessageHelper(mimeMsg, true);
		
		mimeMsgHelper.setTo("mail2shivamraj@gmail.com");
		
		mimeMsgHelper.setSubject("Here is a attached pic!");
		mimeMsgHelper.setText("<h3>Take a look at the attachment:-)</h3>", true);
		
		mimeMsgHelper.addAttachment("coder.jpg", new ClassPathResource("th.jpg"));
		
		javaMailSender.send(mimeMsg);
		System.out.println("Mail with attachment sent!");
	}

	private void sendEmail() {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("mail2shivamraj@gmail.com");
		
		msg.setSubject("Email sent using SpringBoot");
		msg.setText("Hello! \n\n Welcome to SpringBoot, easy to send email wasn't it?");
		
		javaMailSender.send(msg);
	}
}
