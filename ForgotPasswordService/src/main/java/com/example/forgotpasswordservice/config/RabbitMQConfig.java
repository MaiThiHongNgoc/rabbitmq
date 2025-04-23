
package com.example.forgotpasswordservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${app.queue.forgot-password}")
    private String forgotPasswordQueue;

    @Bean
    public Queue forgotPasswordQueue() {
        return new Queue(forgotPasswordQueue, true);
    }
}