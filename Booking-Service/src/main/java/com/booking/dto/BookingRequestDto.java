package com.booking.dto;

import java.time.LocalDate;

import com.booking.enums.BookingStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookingRequestDto {

	
	private Long customerId;
	private Long eventId;
	private Integer numberOfSeats;
	private LocalDate
	 bookingDate;

	
	
	
}
