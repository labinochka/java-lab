package ru.kpfu.itis.userservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

public interface UserNotificationService {

    List<String> getUsersNotifications();

    void listenNotifications(@Payload String message);
}
