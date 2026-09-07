package com.booking.feignConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Customer-Service")
public interface CustomerFeign {
	
	@GetMapping("/customer/view/{id}")
	
	public ResponseEntity<?> viewCustomer( @PathVariable Long id);

}
