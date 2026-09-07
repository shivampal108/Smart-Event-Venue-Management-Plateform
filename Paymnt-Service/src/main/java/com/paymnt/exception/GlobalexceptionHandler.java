package com.paymnt.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.paymnt.response.ApiResponse;
import com.paymnt.response.ErrorResponse;

@RestControllerAdvice

public class GlobalexceptionHandler {
	
	
	
	@ExceptionHandler(PaymntNotProcessException.class)
public ResponseEntity<?> paymntException(PaymntNotProcessException ex){
		
		
		ApiResponse error= new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
