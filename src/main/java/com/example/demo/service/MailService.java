package com.example.demo.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.example.demo.config.EmailConfig;
import com.example.demo.models.User;

@Service
public class MailService {

	@Autowired
	private EmailConfig email;

	public void sendMail(String text, User user, String subject) {

		// create mailsender
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(email.getHost());
		mailSender.setPort(email.getPort());
		mailSender.setUsername(email.getUsername());
		mailSender.setPassword(email.getPassword());

		// Create emailinstance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("keunnebaudouin@gmail.com");
		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject(subject);
		mailMessage.setText(text);

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");

		mailSender.setJavaMailProperties(javaMailProperties);
		// Send
		mailSender.send(mailMessage);

	}

}
