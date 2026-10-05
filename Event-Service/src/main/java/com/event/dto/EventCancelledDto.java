package com.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventCancelledDto {

    private Long eventId;
    private String eventName;
    private String reason;

    // constructors
    // getters/setters
}