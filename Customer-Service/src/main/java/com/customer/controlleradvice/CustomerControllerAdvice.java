package com.customer.controlleradvice;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.customer.customexception.CustomerNotFoundException;
import com.customer.response.ApiResponse;
import com.customer.response.ErrorResponse;

import tools.jackson.databind.exc.InvalidFormatException;

@RestControllerAdvice
public class CustomerControllerAdvice {
	
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> customerNotExhist(CustomerNotFoundException cex) {
		  
		
		ApiResponse error= new ErrorResponse( HttpStatus.NOT_FOUND.value() ,cex.getMessage(), LocalDateTime.now());
		
		return new ResponseEntity<ApiResponse>(error,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse> constraintViolation(
	        MethodArgumentNotValidException ex) {

	    String message = ex.getBindingResult()
	            .getFieldErrors()
	            .get(0)
	            .getDefaultMessage();

	    ApiResponse error = new ErrorResponse(
	            HttpStatus.BAD_REQUEST.value(),
	            message,
	            LocalDateTime.now()
	    );

	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<ApiResponse> handleInvalidFormat(
	        InvalidFormatException ex) {

	    ApiResponse error = new ErrorResponse(
	            HttpStatus.BAD_REQUEST.value(),
	            "Invalid enum value",
	            LocalDateTime.now()
	    );

	    return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(error);
	}
	
	//data intrigrity
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiResponse> handleDataIntegrityViolation(
	        DataIntegrityViolationException ex) {

	    String message = "Data integrity violation";

	    String errorMessage = ex.getMostSpecificCause().getMessage();

	    if (errorMessage != null) {

	        if (errorMessage.contains("Duplicate entry")) {
	            message = "Email already exists";
	        }
	       
	    }

	    ApiResponse error = new ErrorResponse(
	            HttpStatus.CONFLICT.value(),
	            message,
	            LocalDateTime.now()
	    );

	    return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	
}
