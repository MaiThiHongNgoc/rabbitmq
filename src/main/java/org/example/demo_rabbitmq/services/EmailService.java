package org.example.demo_rabbitmq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendResetCode(String toEmail, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your Password Reset Code");
        message.setText("Your reset code is: " + code + "\nUse this code to reset your password.");
        mailSender.send(message);
    }
}

