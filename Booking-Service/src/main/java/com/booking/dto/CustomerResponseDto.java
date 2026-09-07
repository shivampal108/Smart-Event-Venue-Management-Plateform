package com.booking.dto;


import java.time.LocalDate;

import com.booking.enums.BookingStatus;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CustomerResponseDto {

	
	
	private Long custommerId;
	
	
	
	private String customerName;
	
	
	
	private String email;
	
	

	private String mobile;
	
	

	private String city;
	
	
	private String memberShipType;
	
	private String status;

	
	
}
