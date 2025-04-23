package com.example.forgotpasswordservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.queue.forgot-password}")
    private String forgotPasswordQueue;

    public ForgotPasswordService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendForgotPasswordEmail(String email) {
        rabbitTemplate.convertAndSend(forgotPasswordQueue, email);
        System.out.println("Gửi email vào queue: " + email);
    }
}
