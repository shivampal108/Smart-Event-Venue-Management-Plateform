package com.event.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse extends ApiResponse  {
	
	
	public ErrorResponse( int statusCode, String message, LocalDateTime responseTime) {
		super(statusCode, message, responseTime);


	
	}


	
	
	
	
	

}
