package com.event.customexception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.event.response.ApiResponse;
import com.event.response.ErrorResponse;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(EventNotFoundException.class)
	
	public ResponseEntity<?> eventNotFound(EventNotFoundException ex){
		
		ApiResponse error= new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDateTime.now());
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	
	@ExceptionHandler(FeignException.NotFound.class)
	public ResponseEntity<?> venueNotFound(FeignException ex) {

	    ApiResponse error = new ErrorResponse(
	        HttpStatus.NOT_FOUND.value(),
	        ex.getMessage(),
	        LocalDateTime.now()
	       
	    );

	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FeignException.BadRequest.class)
	public ResponseEntity<?> feignBadRequest(FeignException ex) {

	    ApiResponse error = new ErrorResponse(
	        HttpStatus.BAD_REQUEST.value(),
	        ex.getMessage(),
	        LocalDateTime.now()
	    );

	    return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(error);
	}

}
