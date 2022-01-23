package com.example.demo.Controlers;
import javax.mail.*;

import javax.mail.internet.*;

import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class SendEmail {

final String senderPassword = "fljbcpaivjvzvoxf";
final String emailSMTPserver = "smtp.gmail.com";
final String emailServerPort = "587";
String receiverEmailID =null;
String senderEmailID="ishyigakwizera@gmail.com";
public void SendSimpleEmail(String receiverEmailID, String emailSubject, String emailBody)
{
Properties props = new Properties();
props.put("mail.smtp.user",senderEmailID);
props.put("mail.smtp.host", emailSMTPserver);
props.put("mail.smtp.port", emailServerPort);
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.socketFactory.port", emailServerPort);
props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.fallback", "false");
props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
SecurityManager security = System.getSecurityManager();
try
{
Authenticator auth = new SMTPAuthenticator();
Session session = Session.getInstance(props, auth);
MimeMessage msg = new MimeMessage(session);
msg.setText(emailBody);
msg.setSubject(emailSubject);
msg.setFrom(new InternetAddress(senderEmailID));
msg.addRecipient(Message.RecipientType.TO,
new InternetAddress(receiverEmailID));
Transport.send(msg);
System.out.println("Message send Successfully:)");
}
catch (Exception mex)
{
mex.printStackTrace();
}
}

public class SMTPAuthenticator extends javax.mail.Authenticator
{
public PasswordAuthentication getPasswordAuthentication()
{
return new PasswordAuthentication(senderEmailID, senderPassword);
}
}
}

