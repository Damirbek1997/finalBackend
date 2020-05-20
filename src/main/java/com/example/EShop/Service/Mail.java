package com.example.EShop.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {
    public static void SendEmail(String recepient,String subject,String text)throws Exception{

        final Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        final String email = "economybrothere@gmail.com";
        final String password = "776500bb";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        Message message = prepareMessage(session, email, recepient,text,subject);
        Transport.send(message);
        System.out.println("message sent!");
    }

    private static Message prepareMessage (Session session, String myAccountEmail, String recepient, String text, String subject) throws MessagingException {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("economybrothere@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);
            message.setText(text);
            return message;
        }catch (Exception e){
            System.out.println("error");
        }
        return null;
    }


}

