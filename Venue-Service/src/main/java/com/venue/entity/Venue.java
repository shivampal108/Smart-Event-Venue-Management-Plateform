package com.venue.entity;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.venue.enums.Facilities;
import com.venue.enums.Status;
import com.venue.enums.VenueType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venue {
	
	
	@SequenceGenerator(name = "gen2", sequenceName = "venue-seq", allocationSize = 1, initialValue = 1000)
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen2")
	@Id
	private Long venueId;
	
	private String venueName;
	private String city;
	private Integer capacity;
	
	
	@Enumerated(EnumType.STRING)
	private VenueType venueType;
	@Enumerated(EnumType.STRING)
	private Facilities facilities;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	///meta data
	
	
/**/
 
	 

	@Version
	private Integer version;
	
	
	
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime createdAt;
	
	
	
	
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime UpdatedAt;
	
	
	
	
	
	
	
	
}
