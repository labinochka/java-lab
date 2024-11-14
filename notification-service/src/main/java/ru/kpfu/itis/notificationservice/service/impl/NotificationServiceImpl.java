package ru.kpfu.itis.notificationservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.notificationservice.service.NotificationService;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static ru.kpfu.itis.notificationservice.configuration.KafkaConfig.NOTIFICATION_TOPIC;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String message) {
        CompletableFuture<SendResult<String, String>> fileSendResult = kafkaTemplate.send(NOTIFICATION_TOPIC, message);
        fileSendResult.whenComplete((result, ex) -> {
            if (ex == null) {
                Objects.requireNonNull(result);
                System.out.println(result.getProducerRecord().value() + "  " + result.getRecordMetadata().toString());
            } else {
                throw new IllegalArgumentException(ex);
            }
        });
    }
}
