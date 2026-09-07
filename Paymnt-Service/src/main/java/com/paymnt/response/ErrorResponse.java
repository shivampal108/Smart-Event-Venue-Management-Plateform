package com.paymnt.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class ErrorResponse extends ApiResponse  {
	
	
	public ErrorResponse( int statusCode, String message, LocalDateTime responseTime) {
		super(statusCode, message, responseTime);


	
	}


	
	
	
	
	

}
