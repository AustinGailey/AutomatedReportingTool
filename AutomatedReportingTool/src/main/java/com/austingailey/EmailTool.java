package com.austingailey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.email.EmailPopulatingBuilder;
import org.simplejavamail.util.ConfigLoader;
import org.simplejavamail.mailer.config.TransportStrategy;

public class EmailTool {
    protected Logger log = LoggerFactory.getLogger(EmailTool.class);
    protected EmailPopulatingBuilder emailPopulatingBuilder;
    protected Mailer mailer;

    public EmailTool(){
        ConfigLoader.loadProperties("./src/main/resources/simplejavamail.properties",false);
        emailPopulatingBuilder = EmailBuilder.startingBlank();
        mailer = MailerBuilder.buildMailer();
    }

    public Email getEmail(){
        return emailPopulatingBuilder.buildEmail();
    }

    public void addRecipient(String recipientAddress){
        emailPopulatingBuilder.to(recipientAddress);
    }

    public void addSubject(String subject){
        emailPopulatingBuilder.withSubject(subject);
    }

    public void addPlainTextBody(String textBody){
        emailPopulatingBuilder.withPlainText(textBody);
    }


    public void sendEmail(){
        Email email = emailPopulatingBuilder.buildEmail();
        mailer.testConnection();
        mailer.validate(email);
        mailer.sendMail(email);
    }
}