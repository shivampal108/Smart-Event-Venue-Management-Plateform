package com.paymnt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.paymnt.enums.PaymntMode;
import com.paymnt.enums.PaymntStatus;
import com.paymnt.enums.PaymntStatus;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paymnt {
	
	
	

	@SequenceGenerator(name = "gen4", sequenceName = "paymnt-seq", allocationSize = 1, initialValue = 100000)
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen4")
	@Id
	private Long paymentId;
	
	private Long bookingId;
	
	
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private PaymntMode paymentMode;
	
      private String transactionReference;

      @Enumerated(EnumType.STRING)
	private PaymntStatus paymentStatus;
	 
	private  LocalDateTime    paymentDate;

	
	
	
	@Version
	private Integer version;
	
	
	
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime createdAt;
	
	
	
	
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime UpdatedAt;
	
}
