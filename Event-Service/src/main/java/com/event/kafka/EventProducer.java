package com.event.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.event.dto.EventCancelledDto;

@Service
public class EventProducer {


    private final KafkaTemplate<String, EventCancelledDto> kafkaTemplate;

    public EventProducer(
            KafkaTemplate<String, EventCancelledDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishEventCancelled(EventCancelledDto event) {

        kafkaTemplate.send(
            "event-cancelled",
            event.getEventId().toString(),
            event
        );
        
        System.out.println("productd"+ kafkaTemplate);
    }
}