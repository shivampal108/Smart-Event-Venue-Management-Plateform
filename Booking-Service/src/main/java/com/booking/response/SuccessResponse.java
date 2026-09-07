package com.booking.response;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class SuccessResponse<T> extends ApiResponse {
	
	
	private T data;
	
	public SuccessResponse(T data,int statusCode, String message, LocalDateTime responseTime) {
		super(statusCode, message, responseTime);
		
		this.data=data;
		// TODO Auto-generated constructor stub
	}


}
