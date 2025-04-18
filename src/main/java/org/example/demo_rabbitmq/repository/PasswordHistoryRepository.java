package org.example.demo_rabbitmq.repository;

import org.example.demo_rabbitmq.entity.PasswordHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, Long> {
}

