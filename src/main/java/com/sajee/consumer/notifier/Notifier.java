package com.sajee.consumer.notifier;

import com.sajee.consumer.notifier.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Notifier {
    public static final String KAFKA_TOPIC = "content";
    public static final String GROUP_ID = "kafka-sandbox";

    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(
            topics = KAFKA_TOPIC,
            groupId = GROUP_ID
    )
    public void listen(String message) {
        System.out.println("sending via kafka listener.."+message);
        template.convertAndSend("/topic/group", message);
    }
}
