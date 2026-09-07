package com.paymnt.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse<T> extends ApiResponse {
	
	
	private T data;
	
	public SuccessResponse(T data,int statusCode, String message, LocalDateTime responseTime) {
		super(statusCode, message, responseTime);
		
		this.data=data;
		
	}


}
