package com.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.dto.UserRequestDto;
import com.auth.dto.UserResponseDto;
import com.auth.feignconfig.UserServiceFeign;



@RestController
@RequestMapping("/auth-user")
public class AuthControler {
	
	@Autowired
	private UserServiceFeign feign;
	
	
	@PostMapping("/login")
	public UserResponseDto login(@RequestBody UserRequestDto request) {
		
		System.out.println("calling");
		
		return feign.loginUser(request);
		
	}
	
	
	@PostMapping("/register")
	public UserResponseDto register(@RequestBody UserRequestDto request) {
		
		System.out.println("calling");
		
		return feign.registerUser(request);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
