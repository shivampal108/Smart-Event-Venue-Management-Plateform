package com.customer.dto;



import com.customer.enums.MemberShip;
import com.customer.enums.Status;

import jakarta.persistence.Column;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerRequestDto {
	

	@Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters")
	@NotBlank(message = "Name is required!")
	private String customerName;
	
	
	@Email(message = "Invalid email format")

	@NotBlank(message = "Email is required")

	private String email;
	
	
	@Size(min=10, max = 10 ,message = "Please enter valid mobile no!")
	@NotBlank(message = "Mobile is required!")
	private String mobile;
	@Size(max =50 , message = "size is more ")
	private String city;
	
	
	private MemberShip memberShipType;
	
	private Status status;

	
	
}
