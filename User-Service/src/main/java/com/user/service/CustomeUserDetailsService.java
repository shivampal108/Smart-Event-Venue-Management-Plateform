package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.repository.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.user.entity.User user= userRepo.findByUsername(username);
		

        if (user == null) {
            throw new UsernameNotFoundException(
                    "User not found: " + username);
        }
		
//		
//        System.out.println(user.getPassword());
//        System.out.println("from userdetailse service");
//        
        
		return User.builder().username(user.getUsername()).password(user.getPassword()).roles(user.getRole().toString()).build();
		
		
		
				
	}

}
