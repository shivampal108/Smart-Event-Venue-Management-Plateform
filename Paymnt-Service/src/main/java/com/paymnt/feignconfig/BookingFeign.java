package com.paymnt.feignconfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}