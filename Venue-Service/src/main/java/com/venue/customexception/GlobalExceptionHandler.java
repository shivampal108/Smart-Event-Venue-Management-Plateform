package com.venue.customexception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.venue.response.ApiResponse;
import com.venue.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	
	@ExceptionHandler(VenueNotFoundException.class)
	public ResponseEntity<?> customerNotExhist(VenueNotFoundException cex) {
		  
		
		ApiResponse error= new ErrorResponse( HttpStatus.NOT_FOUND.value() ,cex.getMessage(), LocalDateTime.now(),false);
		
		return new ResponseEntity<ApiResponse>(error,HttpStatus.NOT_FOUND);
		
	}
	

}
