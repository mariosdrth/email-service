package com.marios.emailservice.services;

import com.marios.emailservice.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    public void sendEmail(Mail mail) {
        SimpleMailMessage msg = new SimpleMailMessage();
        
        msg.setTo(mail.getReceiver());
        msg.setSubject(mail.getSubject());
        msg.setText(mail.getBody());
        
        javaMailSender.send(msg);
    }
}
