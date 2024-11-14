package ru.kpfu.itis.notificationservice.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    public static final String NOTIFICATION_TOPIC = "notification";

    @Bean
    public NewTopic notificationTopic() {
        return new NewTopic(NOTIFICATION_TOPIC, 1, (short)1);
    }
}
