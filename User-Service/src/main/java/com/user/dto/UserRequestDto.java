package com.user.dto;

import com.user.enums.Roles;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	@Enumerated(EnumType.STRING)
	private Roles role; 
	
}
