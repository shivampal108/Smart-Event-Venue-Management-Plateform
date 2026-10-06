package com.user.service;

import com.user.dto.UserRequestDto;
import com.user.dto.UserResponseDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
	
	public UserResponseDto registerUser(UserRequestDto request);
	
	public UserResponseDto login(UserRequestDto request, HttpServletRequest sReq, HttpServletResponse sRes);
	

}
