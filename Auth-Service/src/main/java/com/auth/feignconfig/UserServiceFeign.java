package com.auth.feignconfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.auth.dto.UserRequestDto;
import com.auth.dto.UserResponseDto;


@FeignClient("User-Service")
public interface UserServiceFeign {
	
	@PostMapping("/user/register")
	public UserResponseDto registerUser(@RequestBody UserRequestDto request);
	
	
	@PostMapping("/user/login")
	public UserResponseDto loginUser(@RequestBody UserRequestDto request);
	

}
