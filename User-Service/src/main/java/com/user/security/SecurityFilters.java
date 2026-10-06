package com.user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.user.service.CustomeUserDetailsService;

@Configuration
public class SecurityFilters {
	
	
	
	@Bean
	
	public SecurityFilterChain filters(HttpSecurity http) {
		
		
		
		http .csrf(csrf -> csrf.disable()). authorizeHttpRequests(a->
		a.requestMatchers("/user/register/**").permitAll()
		.requestMatchers("/user/login/**").permitAll()
		.requestMatchers("/actuator/**").permitAll()
				
				
				
				);
		
		
		return http.build();
		
	}
	
	
	
	
	//password encoder
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	
	@Bean
	public AuthenticationManager authenticationManager(
			CustomeUserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder
			)
	
	
	
	
	{
		
		
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		
		return new ProviderManager(provider);
		
		
		
	}
	
	
	
	
	
}
