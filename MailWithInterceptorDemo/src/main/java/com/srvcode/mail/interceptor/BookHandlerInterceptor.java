package com.srvcode.mail.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class BookHandlerInterceptor implements HandlerInterceptor {

	@Autowired
	private JavaMailSender javaMailSender;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getParameter("bookId") != null) {
			System.out.println("preHandle() method sending book access mail...");
			sendEmail(request.getParameter("bookId"), "Book accessed");
			System.out.println("Done");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (request.getParameter("bookId") != null) {
			System.out.println("postHandle() method sending book access mail...");
			sendEmail(request.getParameter("bookId"), "Book access complete");
			System.out.println("Done");
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) throws Exception {
		if (request.getParameter("bookId") != null) {
			System.out.println("Sending book request & response completion mail...");
			sendEmail(request.getParameter("bookId"), "Request & Response complete");
			System.out.println("Done");
		}
	}

	private void sendEmail(String bookId, String messageText) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("mail2shivamraj@gmail.com");
		msg.setSubject("Book related activity for book: " + bookId);
		msg.setText(messageText + ": " + dateFormat.format(new Date()));
		
		javaMailSender.send(msg);
		
	}
}
