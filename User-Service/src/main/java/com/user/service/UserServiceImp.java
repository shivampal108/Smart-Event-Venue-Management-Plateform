package com.user.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.dto.UserRequestDto;
import com.user.dto.UserResponseDto;
import com.user.entity.User;
import com.user.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private PasswordEncoder pEncode;
	
	@Autowired
	private AuthenticationManager authManager;
	@Override
	public UserResponseDto registerUser(UserRequestDto request) {
		
		User user= new User();
		
		BeanUtils.copyProperties(request, user);
		
		user.setPassword(pEncode.encode(request.getPassword()));
		
		UserResponseDto response= UserResponseDto.builder()
				.build();
		
		
		
		BeanUtils.copyProperties(user,response);

		uRepo.save(user);
		
		// TODO Auto-generated method stub
		return response;
	}

	@Override
	public UserResponseDto login(
	        UserRequestDto request,
	        HttpServletRequest sReq,
	        HttpServletResponse sRes) {

	    UsernamePasswordAuthenticationToken token =
	            UsernamePasswordAuthenticationToken.unauthenticated(
	                    request.getUsername(),
	                    request.getPassword());

	    System.out.println("1. LOGIN SERVICE");
	    System.out.println("2. BEFORE AUTHENTICATION");
	    
//	    System.out.println(pEncode.encode(request.getPassword()));

	    try {

	        Authentication authentication =
	                authManager.authenticate(token);

	        System.out.println("3. AFTER AUTHENTICATION");
	        System.out.println("Authenticated: " + authentication.isAuthenticated());
	        System.out.println("Username: " + authentication.getName());
	        System.out.println("Authorities: " + authentication.getAuthorities());

	    } catch (Exception e) {

	        System.out.println("AUTHENTICATION FAILED");
	        System.out.println("Exception: " + e.getClass().getName());
	        System.out.println("Message: " + e.getMessage());

	        e.printStackTrace();
	    }

	    return null;
	}
}