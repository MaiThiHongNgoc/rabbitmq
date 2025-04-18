package org.example.demo_rabbitmq.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ForgotPasswordService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${app.queue.forgot-password}")
    private String queueName;

    public void sendResetCodeToQueue(String email) {
        String code = String.format("%06d", new Random().nextInt(999999)); // sinh mã 6 số
        Map<String, String> message = new HashMap<>();
        message.put("email", email);
        message.put("code", code);
        rabbitTemplate.convertAndSend(queueName, message);
    }
}

