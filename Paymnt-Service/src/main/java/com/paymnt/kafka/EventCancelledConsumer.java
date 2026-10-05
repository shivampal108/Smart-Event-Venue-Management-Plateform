package com.paymnt.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.paymnt.dto.EventCancelledDto;
import com.paymnt.service.PaymntService;

@Service
public class EventCancelledConsumer {
	
	@Autowired
	private PaymntService pService;

    @KafkaListener(
        topics = "event-cancelled",
        groupId = "refund-group"
    )
    public void consumeEventCancelled(EventCancelledDto event) {

        System.out.println(
            "Event cancelled: " + event.getEventId()
        );

        System.out.println(
            "Event name: " + event.getEventName()
        );

        // Next step:
        // find bookings for this event
        // check successful payments
        // initiate refund
        
        pService.refundAndReleaseSeats(event.getEventId());
       System.out.println("refunded");
    }
}