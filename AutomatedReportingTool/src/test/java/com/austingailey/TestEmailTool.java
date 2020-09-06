package com.austingailey;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestEmailTool {
    
    @Test
    public void testEmail(){
        EmailTool emailTool = new EmailTool();
        emailTool.addRecipient("cgrever17@gmail.com");
        emailTool.addSubject("I'm watching you");
        emailTool.addPlainTextBody("I can send emails!");
        emailTool.sendEmail();
        Assertions.assertTrue(true);
    }
}