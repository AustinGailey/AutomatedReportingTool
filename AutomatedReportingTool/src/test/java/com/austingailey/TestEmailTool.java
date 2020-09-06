package com.austingailey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.simplejavamail.email.Email;
import javax.activation.FileDataSource;

public class TestEmailTool {
    
    @Test
    public void testEmailToolConstructor(){
        EmailTool emailTool = new EmailTool();
        assertNotNull(emailTool);
    }

    @Test
    public void testGetEmail(){
        EmailTool emailTool = new EmailTool();
        Email email = emailTool.getEmail();
        assertNotNull(email);
    }

    @Test
    public void testAddRecipient(){
        EmailTool emailTool = new EmailTool();
        emailTool.addRecipient("test@test.com");
        Email email = emailTool.getEmail();
        assertEquals("test@test.com",email.getRecipients().get(0).getAddress());
    }

    @Test
    public void testAddSubject(){
        EmailTool emailTool = new EmailTool();
        emailTool.addSubject("Test Subject");
        Email email = emailTool.getEmail();
        assertEquals("Test Subject",email.getSubject());
    }

    @Test
    public void testAddPlainTextBody(){
        EmailTool emailTool = new EmailTool();
        emailTool.addPlainTextBody("Test Body");
        Email email = emailTool.getEmail();
        assertEquals("Test Body",email.getPlainText());
    }

    @Test
    public void addAttachment(){
        EmailTool emailTool = new EmailTool();
        emailTool.addAttachment("TestFileRenamed.txt", new FileDataSource("src/test/resources/TestTextFile.txt"));
        Email email = emailTool.getEmail();
        assertEquals("TestFileRenamed.txt",email.getAttachments().get(0).getName());
    }
}