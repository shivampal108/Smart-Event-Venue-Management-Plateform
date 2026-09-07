package com.paymnt.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paymnt.dto.BookingResponseDto;
import com.paymnt.dto.PaymntRequestDto;
import com.paymnt.dto.PaymntResponseDto;
import com.paymnt.entity.Paymnt;
import com.paymnt.enums.BookingStatus;
import com.paymnt.enums.PaymntStatus;
import com.paymnt.exception.PaymntNotProcessException;
import com.paymnt.feignconfig.BookingFeign;
import com.paymnt.repository.PaymntRepository;
import com.paymnt.response.SuccessResponse;

import jakarta.transaction.Transactional;

@Service
public class PaymntServiceImp implements PaymntService {
	
	@Autowired
	private PaymntRepository pRepo;
	
	@Autowired
	private BookingFeign bFeign;

	@Override
	@Transactional
	public PaymntResponseDto makePymnt(PaymntRequestDto request) {

		
		ResponseEntity<SuccessResponse<BookingResponseDto>> booking =
		        bFeign.viewBooking(request.getBookingId());		
		Paymnt pay= new Paymnt();
		
		
		
		if(booking.getBody().getData().getBookingStatus()!=BookingStatus.PENDING) {
			
			
		throw new PaymntNotProcessException("Paymnt Aleady Done!");
		}
		
		
		
		else {
		
		
		BeanUtils.copyProperties(request, pay);
		
		

		
		
		//generate transacton id 
		

	    String characters =
	            "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	    SecureRandom random = new SecureRandom();

	    StringBuilder reference = new StringBuilder(10);

	    for (int i = 0; i < 10; i++) {
	        reference.append(
	            characters.charAt(
	                random.nextInt(characters.length())
	            )
	        );
	    }
		
		
		pay.setPaymentDate(LocalDateTime.now());
		pay.setAmount(booking.getBody().getData().getTotalAmount());
	    pay.setTransactionReference(reference.toString());
	    pay.setPaymentStatus(PaymntStatus.COMPLETED);
		
		pay.setPaymentStatus(PaymntStatus.COMPLETED);
		
	pay=	pRepo.save(pay);
		
		
		bFeign.updateBookingStatus(pay.getBookingId());
	 
	 
	 
		
		PaymntResponseDto pResponse= PaymntResponseDto.builder().build();
		
		BeanUtils.copyProperties(pay, pResponse);
		
		return pResponse;
		
		
		}
		
		
		
		
		
	}

	@Override
	public String refund(Long paymntId) {
		
	Paymnt pay=	pRepo.findById(paymntId).orElseThrow(()-> new PaymntNotProcessException("paymnt not found!"));
		
		
	pay.setPaymentStatus(PaymntStatus.REFUND);
	
	
	
	pRepo.save(pay);
	
	
		return "refunded";
	}

	@Override
	public String getPaymntMode(Long paymntId) {
		
		Paymnt pay=	pRepo.findById(paymntId).orElseThrow(()-> new PaymntNotProcessException("paymnt not found!"));
			
		
		return pay.getPaymentStatus().toString();
		
		
	}
	
	
	

}
