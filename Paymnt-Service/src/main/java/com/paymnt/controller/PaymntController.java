package com.paymnt.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymnt.dto.PaymntRequestDto;
import com.paymnt.dto.PaymntResponseDto;
import com.paymnt.response.ApiResponse;
import com.paymnt.response.SuccessResponse;
import com.paymnt.service.PaymntService;

@RestController
@RequestMapping("/paymnt")
public class PaymntController {
	
	
	@Autowired
	
	private PaymntService pay;

	
	@PostMapping("/pay")
	public ResponseEntity<?> initiatePaymnt( @RequestBody  PaymntRequestDto request){
		
		ApiResponse success= new SuccessResponse<PaymntResponseDto>(pay.makePymnt(request), HttpStatus.CREATED.value(), "paymnt successfull", LocalDateTime.now());
		
		return ResponseEntity.status(200).body(success);
		
	}
	
	
	
	@PatchMapping("/refund/{id}")
	
	public String refund(@PathVariable Long id) {
		
		return pay.refund(id);
	}
	
	
	@GetMapping("/paymnt-status/{id}")
	
	public String getPaymntStatus(@PathVariable Long id) {
		
		return pay.getPaymntMode(id);
	}
	
	
}
