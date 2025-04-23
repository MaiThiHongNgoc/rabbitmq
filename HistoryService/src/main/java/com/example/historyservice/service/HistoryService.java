
package com.example.historyservice.service;



import com.example.historyservice.model.PasswordHistory;
import com.example.historyservice.repository.PasswordHistoryRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    private final PasswordHistoryRepository passwordHistoryRepository;

    @Autowired
    public HistoryService(PasswordHistoryRepository passwordHistoryRepository) {
        this.passwordHistoryRepository = passwordHistoryRepository;
    }

    @RabbitListener(queues = "${app.queue.password-history}")
    public void receivePasswordHistory(String email) {
        // Logic để lưu lịch sử thay đổi mật khẩu vào database
        savePasswordHistory(email);
    }

    public void savePasswordHistory(String email) {
        PasswordHistory passwordHistory = new PasswordHistory();
        passwordHistory.setEmail(email);
        passwordHistory.setChangeDate(System.currentTimeMillis());
        // Lưu vào database
        passwordHistoryRepository.save(passwordHistory);
        System.out.println("Đã lưu lịch sử thay đổi mật khẩu cho email: " + email);
    }
}