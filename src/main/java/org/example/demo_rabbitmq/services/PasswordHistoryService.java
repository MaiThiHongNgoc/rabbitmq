package org.example.demo_rabbitmq.services;

import org.example.demo_rabbitmq.entity.PasswordHistory;
import org.example.demo_rabbitmq.repository.PasswordHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PasswordHistoryService {

    @Autowired
    private PasswordHistoryRepository repository;

    public void savePasswordChange(Long userId, String oldPassword) {
        PasswordHistory history = new PasswordHistory();
        history.setUserId(userId);
        history.setOldPassword(oldPassword);
        history.setChangedAt(LocalDateTime.now());
        repository.save(history);
    }
}

