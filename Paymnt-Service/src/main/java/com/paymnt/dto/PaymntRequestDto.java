package com.paymnt.dto;



import com.paymnt.enums.PaymntMode;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymntRequestDto {

	
	
	private Long bookingId;
	
	
	
	
	@Enumerated(EnumType.STRING)
	private PaymntMode paymentMode;
	
   
	
	
	

	
	
}
