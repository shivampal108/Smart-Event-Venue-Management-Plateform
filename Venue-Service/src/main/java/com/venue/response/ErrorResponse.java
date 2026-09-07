package com.venue.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse extends ApiResponse  {
	
	
	public ErrorResponse( int statusCode, String message, LocalDateTime responseTime, boolean success) {
		super(statusCode, message, responseTime,success);


	
	}


	
	
	
	
	

}
