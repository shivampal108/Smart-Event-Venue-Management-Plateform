package com.user.service;

import com.user.dto.UserRequestDto;
import com.user.dto.UserResponseDto;



public interface UserService {
	
	public UserResponseDto registerUser(UserRequestDto request);
	
	public UserResponseDto login(UserRequestDto request);
	
	public UserResponseDto updateUser(String username, UserRequestDto request);
	
	
	public String deleteUser(String userName);
	
	public UserResponseDto  viewUser(Long id);
	

}
