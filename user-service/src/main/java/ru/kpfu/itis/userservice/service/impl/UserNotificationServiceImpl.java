package ru.kpfu.itis.userservice.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.userservice.service.UserNotificationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {

    private final List<String> notifications = new ArrayList<>();

    @Override
    public List<String> getUsersNotifications() {
        return notifications;
    }

    @Override
    @KafkaListener(topics = "notification", groupId = "notificationGroupId")
    public void listenNotifications(@Payload String message) {
        notifications.add(message);
    }
}
