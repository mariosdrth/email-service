package com.marios.emailservice.services;

import com.marios.emailservice.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment env;
    private static final String DOUBLE_NEW_LINE = "\n";
    
    public void sendEmail(Mail mail) {
        SimpleMailMessage msg = new SimpleMailMessage();
        String body;
        
        msg.setTo(Objects.requireNonNull(env.getProperty("mail.receiver")));
        msg.setSubject("MY_SITE - Email from: " + mail.getSenderName());
        
        body = "Email from: " + mail.getSenderName() + ". " + DOUBLE_NEW_LINE + "Contact email address: " +
                mail.getSenderEmail() + ". " + DOUBLE_NEW_LINE + "Message: \n" + mail.getMessage();
        
        msg.setText(body);
        
        javaMailSender.send(msg);
    }
}
