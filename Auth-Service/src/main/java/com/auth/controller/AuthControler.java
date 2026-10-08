package com.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.dto.AuthResponse;
import com.auth.dto.UserRequestDto;
import com.auth.dto.UserResponseDto;
import com.auth.feignconfig.UserServiceFeign;
import com.auth.service.JwtService;



@RestController
@RequestMapping("/auth-user")
public class AuthControler {
	
	@Autowired
	private UserServiceFeign feign;
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody UserRequestDto request) {
		
		System.out.println("calling");
		
	UserResponseDto resp=	 feign.loginUser(request);
	
	System.out.println(resp);
		 
	String token = jwtService.generateToken(resp.getUsername(), resp.getRole()); 
	
	System.out.println(token);
	
		 return new AuthResponse(token, "Bearer", resp.getUsername(), resp.getRole());
		
	}
	
	
	@PostMapping("/register")
	public UserResponseDto register(@RequestBody UserRequestDto request) {
		
		System.out.println("calling");
		
		return feign.registerUser(request);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
