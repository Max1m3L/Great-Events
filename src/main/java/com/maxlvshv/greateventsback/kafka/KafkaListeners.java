package com.maxlvshv.greateventsback.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "NewTopic", groupId = "foo")
    void listener(String data) {
        System.out.println("Listener gets: " + data);
    }
}
