package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserRequestDto;
import com.user.dto.UserResponseDto;
import com.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService uService;
	
	@PostMapping("/register")
	public UserResponseDto register(@RequestBody UserRequestDto request) {
		
		return uService.registerUser(request);
		
	}
	
	
	@PostMapping("/login")

	public UserResponseDto login(@RequestBody UserRequestDto request
			,  HttpServletRequest httpRequest,
	        HttpServletResponse httpResponse)
	
	
	
	{
		System.out.println(":controller");
		
	    return uService.login(request);
	}
	
	
	
	
	
	
}
