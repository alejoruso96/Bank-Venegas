package com.example.bank.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic clienteTopic() {
        return TopicBuilder.name("cliente-events")
                .partitions(1)
                .replicas(1)
                .build();
    }
}