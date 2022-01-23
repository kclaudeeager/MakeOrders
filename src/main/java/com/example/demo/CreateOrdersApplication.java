package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.demo.Controlers.SendEmail;
import com.example.demo.Services.EmailSender;

@SpringBootApplication
public class CreateOrdersApplication {
	@Autowired
private EmailSender mailSender;
	@Autowired
	private SendEmail email;
	public static void main(String[] args) {
		SpringApplication.run(CreateOrdersApplication.class, args);

	}
	@EventListener(ApplicationReadyEvent.class)
	public void trigerMail() {
		String password="fljbcpaivjvzvoxf";
		String tomail="claudekwizera003@gmail.com";
		String subject="Testing Mailsender";
		String body="Hello this is Email from Springboot backend";
		//email.SendSimpleEmail(tomail,subject,body);
		//mailSender.SendSimpleEmail("ngabonziza@gmail.com","Hello this is Email from Springboot backend by mr. claude", "Testing Mailsender");
		mailSender.semdEmailWithAttachement(tomail, body, subject,"C:\\Users\\NADINE\\Downloads\\Documents\\Unit 1.pptx");
	}

}
