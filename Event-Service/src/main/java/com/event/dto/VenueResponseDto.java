package com.event.dto;

import com.event.venue.enums.Facilities;
import com.event.venue.enums.Status;
import com.event.venue.enums.VenueType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class VenueResponseDto {

	
private Long venueId;
	
	private String venueName;
	private String city;
	private Integer capacity;
	
	
	@Enumerated(EnumType.STRING)
	private VenueType venueType;
	@Enumerated(EnumType.STRING)
	private Facilities facilities;
	@Enumerated(EnumType.STRING)
	private Status status;
}
