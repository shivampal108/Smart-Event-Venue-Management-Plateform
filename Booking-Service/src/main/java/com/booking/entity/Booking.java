package com.booking.entity;

import java.time.LocalDate;

import com.booking.enums.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Booking {
	
	@Id
	@SequenceGenerator(name = "gen3", allocationSize = 1, initialValue = 10000, sequenceName = "booking-seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "gen3")
	private Long bookingId;
	private Long customerId;
	private Long eventId;
	private Integer numberOfSeats;
	private LocalDate bookingDate;
	private Double totalAmount;
	
	
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;
	
	//meta data
	
	
	@Version
	private Integer version;

}
