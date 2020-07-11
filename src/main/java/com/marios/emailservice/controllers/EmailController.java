package com.marios.emailservice.controllers;

import com.marios.emailservice.model.Mail;
import com.marios.emailservice.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/send-email")
public class EmailController {
    
    @Autowired
    private EmailService emailService;
    private final Logger logger = LoggerFactory.getLogger(EmailController.class);
    
    @PostMapping
    @ResponseBody
    public void sendEmail(@RequestBody Mail mail) {
        try {
            emailService.sendEmail(mail);
        } catch (MailException e) {
            logger.error(e.getMessage());
        }
    }
}
