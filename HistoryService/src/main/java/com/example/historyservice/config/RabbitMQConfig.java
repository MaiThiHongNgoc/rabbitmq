
package com.example.historyservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;


@Configuration
public class RabbitMQConfig {

    @Value("${app.queue.password-history}")
    private String passwordHistoryQueue;

    @Bean
    public Queue passwordHistoryQueue() {
        return new Queue(passwordHistoryQueue, true);
    }
}
