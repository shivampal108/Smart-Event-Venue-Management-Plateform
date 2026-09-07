package com.booking.controller;

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

import com.booking.dto.BookingRequestDto;
import com.booking.dto.BookingResponseDto;
import com.booking.response.ApiResponse;
import com.booking.response.SuccessResponse;
import com.booking.service.BookingService;

@RestController

@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> book( @RequestBody BookingRequestDto req) {
	
		return ResponseEntity.status(HttpStatus.CREATED).body(bService.addBooking(req));
		
	}
	
	

	@GetMapping("/view/{id}")
	public ResponseEntity<?> book( @PathVariable Long id) {
		
		
		ApiResponse success = new SuccessResponse<BookingResponseDto>(bService.viewBooking(id), HttpStatus.OK.value(), "booking details featched successfully",LocalDateTime.now() );
	
		return ResponseEntity.status(HttpStatus.CREATED).body(success);
		
	}
	
	
	@PostMapping("/cancle/{id}/{noOfseat}/{paymntId}")
	public ResponseEntity<?> cancleBooking( @PathVariable Long id ,@PathVariable Integer noOfseat , @PathVariable Long paymntId) {
	
		return ResponseEntity.status(HttpStatus.CREATED).body(bService.cancleBooking(id, noOfseat,paymntId));
		
	}
	
	@PatchMapping
	("status/{id}")
	public ResponseEntity<?> updateBookingStatus( @PathVariable Long id ) {
		
		ApiResponse success = new SuccessResponse<BookingResponseDto>(bService.updateStatus(id), HttpStatus.OK.value(), "booking details updated successfully",LocalDateTime.now() );
		
		return ResponseEntity.status(HttpStatus.CREATED).body(success);
		
	
	
		
	}
	
	
	
	
	
}
