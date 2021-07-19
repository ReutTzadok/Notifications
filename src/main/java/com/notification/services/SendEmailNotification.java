package com.notification.services;

import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
@Primary
public class SendEmailNotification implements SendNotification{

    public SendEmailNotification(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    private final JavaMailSender mailSender;


    @Override
    public void send(String to, String content) {
        String subject = "Stock Alert!!";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);

        //todo remove
        System.out.println("Email sent");
    }
}
