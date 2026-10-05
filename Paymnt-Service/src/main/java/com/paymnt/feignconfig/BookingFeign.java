package com.paymnt.feignconfig;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.paymnt.dto.BookingResponseDto;
import com.paymnt.response.SuccessResponse;

@FeignClient("Booking-Service")
public interface BookingFeign {

    @GetMapping("/booking/view/{bookingId}")
    ResponseEntity<SuccessResponse<BookingResponseDto>> viewBooking(
            @PathVariable("bookingId") Long id);

    @PatchMapping("/booking/status/{id}")
    ResponseEntity<SuccessResponse<BookingResponseDto>> updateBookingStatus(
            @PathVariable("id") Long id);
    
    @PutMapping("/booking/cancle/{eventId}")
    
   List<Long> cancleBookingStatus(
            @PathVariable("eventId") Long id);
    
    
    
}