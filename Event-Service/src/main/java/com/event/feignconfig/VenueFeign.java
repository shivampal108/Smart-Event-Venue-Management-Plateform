package com.event.feignconfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Venue-Service")
public interface VenueFeign {

	@GetMapping("/venue/view/{id}")
	public ResponseEntity<?> viewVenue( @PathVariable
			Long id);
	
	
}
