package org.example.demo_rabbitmq.listener;

import org.example.demo_rabbitmq.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ForgotPasswordListener {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${app.queue.forgot-password}")
    public void receiveMessage(Map<String, String> message) {
        String email = message.get("email");
        String code = message.get("code");

        if (email != null && code != null) {
            emailService.sendResetCode(email, code);
        }
    }
}

