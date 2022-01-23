package com.example.demo.Controlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Order;

@RestController
public class SendEmailController {
   @RequestMapping(value="/sendemail/")
   public String sendEmail() {
      return "Email sent successfully";
   }   
   private void sendmail() throws AddressException, MessagingException, IOException {
	   Properties props = new Properties();
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.port", "587");
	   
	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication("ishyigakwizera@gmail.com", "Algorthim123");
	      }
	   });
	   Message msg = new MimeMessage(session);
	   msg.setFrom(new InternetAddress("ishyigakwizera@gmail.com", false));

	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("claudekwizera003@gmail.com"));
	   msg.setSubject("Order requesemail");
	   msg.setContent("Hello this is a test email from Kwizera claude", "text/html");
	   msg.setSentDate(new Date());

	   MimeBodyPart messageBodyPart = new MimeBodyPart();
	   messageBodyPart.setContent("Hello this is a test email from Kwizera claude", "text/html");

	   Multipart multipart = new MimeMultipart();
	   multipart.addBodyPart(messageBodyPart);
	   MimeBodyPart attachPart = new MimeBodyPart();

	   attachPart.attachFile("/var/tmp/image19.png");
	   multipart.addBodyPart(attachPart);
	   msg.setContent(multipart);
	   Transport.send(msg);   
	}
}