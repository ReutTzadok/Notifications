package com.notification.configurations;


import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.*;
import java.util.Properties;

@Configuration
public class EmailConfiguration {

    @Value(value = "${emailDetailsPath}")
    private String emailDetailsPath;
    private String userName;
    private String password;

    @SneakyThrows
    private void fillEmailConnectionDetails()
    {
        BufferedReader reader = new BufferedReader(new FileReader(emailDetailsPath));
        userName = reader.readLine();
        password = reader.readLine();
    }


    @Bean
    public JavaMailSender getJavaMailSender()
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(25);

        if (userName == null)
            fillEmailConnectionDetails();

        mailSender.setUsername(userName);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
