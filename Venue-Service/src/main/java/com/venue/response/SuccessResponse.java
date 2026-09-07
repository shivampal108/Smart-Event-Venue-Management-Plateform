package com.venue.response;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class SuccessResponse<T> extends ApiResponse {
	
	
	private T data;
	
	public SuccessResponse(T data,int statusCode, String message, LocalDateTime responseTime, boolean success) {
		super(statusCode, message, responseTime, success);
		
		this.data=data;
		
	}


}
