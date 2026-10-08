package com.user.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.dto.UserRequestDto;
import com.user.dto.UserResponseDto;
import com.user.entity.User;
import com.user.repository.UserRepository;





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
	public UserResponseDto login( UserRequestDto request ) {

	    UsernamePasswordAuthenticationToken token =
	            UsernamePasswordAuthenticationToken.unauthenticated(
	                    request.getUsername(),
	                    request.getPassword());

//	    System.out.println("1. LOGIN SERVICE");
//	    System.out.println("2. BEFORE AUTHENTICATION");
	    
//	    System.out.println(pEncode.encode(request.getPassword()));

//	    try {

	        Authentication authentication =
	                authManager.authenticate(token);

//	        System.out.println("3. AFTER AUTHENTICATION");
//	        System.out.println("Authenticated: " + authentication.isAuthenticated());
//	        System.out.println("Username: " + authentication.getName());
//	        System.out.println("Authorities: " + authentication.getAuthorities());

//	    } catch (Exception e) {
//
//	        System.out.println("AUTHENTICATION FAILED");
//	        System.out.println("Exception: " + e.getClass().getName());
//	        System.out.println("Message: " + e.getMessage());
//
//	        e.printStackTrace();
//	    }
	        
	        User user= uRepo.findByUsername(request.getUsername());
	        
	        UserResponseDto response= UserResponseDto.builder().build();
	        
	        BeanUtils.copyProperties(user, response);

	    return response ;
	}

	@Override
	public UserResponseDto updateUser(String username, UserRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String userName) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		String loggedUserName= authentication.getName();
		
		System.out.println(loggedUserName);
		
	User user=	uRepo.findByUsername(loggedUserName);
		
		// TODO Auto-generated method stub
	
	if(userName.equals(loggedUserName)) {
		uRepo.delete(user);
	}
	
	else {
		System.out.println("user not same or suthorize ot delete another user");
		throw new RuntimeException("user not same");
		
	}
		return "deleted";
	}

	@Override
	public UserResponseDto viewUser(Long id) {

				
				
				
		User user=uRepo.findById(id).orElseThrow();
		
		UserResponseDto response= UserResponseDto.builder().build();
		BeanUtils.copyProperties(user, response);
		
		return response;
	}
}