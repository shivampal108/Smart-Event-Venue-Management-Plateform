package com.customer.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.customer.enums.MemberShip;
import com.customer.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ms-customer")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long custommerId;
	
	
	
	private String customerName;
	
	

	@Column(unique = true, nullable = false)

	

	private String email;
	
	

	private String mobile;
	

	private String city;
	
	@Enumerated(EnumType.STRING)
	private MemberShip memberShipType;
	
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
