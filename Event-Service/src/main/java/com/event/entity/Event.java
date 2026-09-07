package com.event.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.event.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.Data;



@Entity
@Data
public class Event {

	
	
	
	@Id
	@SequenceGenerator(name = "gen1", allocationSize = 1, initialValue = 100, sequenceName = "event-seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "gen1")
	private Long eventId;
	
	
	
	private String eventName;
	private String eventCategory;
	
	private LocalDate eventDate;
	private LocalTime eventTime;
	
	private Long  venueId;
	
	
	private Integer  totalSeats;
	
	
	private Integer availableSeats;
	
	
	private Double ticketPrice;
	
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	//meta data
	
	
	@Version
	private Integer version;
	
	
	
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime createdAt;
	
	
	
	
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime UpdatedAt;
	
	
	
	
}
