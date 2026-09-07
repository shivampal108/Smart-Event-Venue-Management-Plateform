package com.booking.feignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.booking.dto.PaymntRequestDto;


@FeignClient("Paymnt-Service")
public interface PaymntFeign {

	
	
	@PatchMapping("/paymnt/refund/{id}")
	
	public String refund(@PathVariable Long id);
	
	
	
	@GetMapping("/paymnt/paymnt-status/{id}")
	
	
	public String getPaymntMode(@PathVariable Long id);

	

	@PostMapping("/pay")
	
	public ResponseEntity<?> savePaymnt(@RequestBody  PaymntRequestDto request);
	
}
