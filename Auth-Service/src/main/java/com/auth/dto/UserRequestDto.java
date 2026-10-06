package com.auth.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserRequestDto {

	
    private String username;
	
	private String password;
	
	private String role; 
	
}
