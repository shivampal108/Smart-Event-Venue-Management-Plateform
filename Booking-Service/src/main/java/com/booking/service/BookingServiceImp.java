package com.booking.service;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.customexception.BookingNotFoundException;
import com.booking.customexception.NoAvilableSeatException;
import com.booking.dto.BookingRequestDto;
import com.booking.dto.BookingResponseDto;
import com.booking.dto.EventResponseDto;
import com.booking.entity.Booking;
import com.booking.enums.BookingStatus;
import com.booking.feignConfig.CustomerFeign;
import com.booking.feignConfig.EventFeign;
import com.booking.feignConfig.PaymntFeign;
import com.booking.repository.BookingRepository;
import com.booking.response.SuccessResponse;




@Service
public class BookingServiceImp implements BookingService {

	
	@Autowired
	private EventFeign eventFeign;
	
	
	@Autowired
	private CustomerFeign customerFeign;
	
	@Autowired
	private BookingRepository bRepo;
	
	@Autowired
	private PaymntFeign paymntfeign;

	@Override
	public BookingResponseDto addBooking(BookingRequestDto booking) {
		
//	ApiResponse event=	(SuccessResponse<EventResponseDto>) eventFeign.viewEvent(booking.getEventId()).getBody();
		
		SuccessResponse<EventResponseDto> response =
		        (SuccessResponse<EventResponseDto>) eventFeign.viewEvent(booking.getEventId()).getBody();

		EventResponseDto event = response.getData();
	
	
	
	if(booking.getNumberOfSeats()>event.getAvailableSeats()) {
		throw new NoAvilableSeatException("seat not avilable for this event!");
	}
	else {
		customerFeign.viewCustomer(booking.getCustomerId());
		
	
	
		
		
		
		Booking b= new Booking();
		
		BookingResponseDto b1=BookingResponseDto.builder().build();
		
		
		
		BeanUtils.copyProperties(booking, b);
		
		b.setBookingStatus(BookingStatus.PENDING);
		
		
		double price= b.getNumberOfSeats()*event.getTicketPrice();
		
		b.setTotalAmount(price);
		
		b=bRepo.save(b);
		
		BeanUtils.copyProperties(b, b1);
		
		
		eventFeign.updateSeats( booking.getNumberOfSeats(), booking.getEventId());
		
		
		return b1;
		
	}
	}

	
	
	@Override
	public BookingResponseDto viewBooking(Long id) {
	
		Booking b= bRepo.findById(id).orElseThrow(()-> new BookingNotFoundException("Booking not exhist with this id: "+ id));
		
		BookingResponseDto response= BookingResponseDto.builder().build();
	BeanUtils.copyProperties(b, response);	
	
	
	return response;
		
		
		
		
		
		
	}

	@Override
	public List<BookingResponseDto> viewAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBookings(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingResponseDto updateBookings(BookingRequestDto booking, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	// use when paymnt success full
	@Override
	public BookingResponseDto updateStatus(Long id) {
		
	Booking b=	bRepo.findById(id).orElseThrow(()-> new BookingNotFoundException("Booking not exhist with this id: "+ id));
		
	BookingResponseDto b1= BookingResponseDto.builder().build();
	
	b.setBookingStatus(BookingStatus.APPROVED);
	bRepo.save(b);
	BeanUtils.copyProperties(b, b1);
		
		return b1;
	}



	@Override
	public BookingResponseDto cancleBooking(Long bookingId, Integer noOfSeat, Long paymntID) {
		
	
	
	Booking bookingResponse=  bRepo.findById(bookingId).orElseThrow(()-> new BookingNotFoundException("Booking not exhist!"));
	
eventFeign.viewEvent(bookingResponse.getEventId()).getBody();

	
if(noOfSeat>bookingResponse.getNumberOfSeats()) {
	throw new NoAvilableSeatException("seat is too much total booked seat is "+ bookingResponse.getNumberOfSeats() );
}
else if(noOfSeat<=0) {
	
	throw new NoAvilableSeatException("seat can't be negative or zero total booked seat is "+ bookingResponse.getNumberOfSeats() );

	
}

else if(noOfSeat==bookingResponse.getNumberOfSeats()) {
	
	
	paymntfeign.refund(paymntID);
	
	eventFeign.addSeats(noOfSeat, bookingResponse.getEventId());
	
	bookingResponse.setNumberOfSeats(bookingResponse.getNumberOfSeats()- noOfSeat);
	
	bookingResponse=

			bRepo.save(bookingResponse);



			BookingResponseDto response= BookingResponseDto.builder().build();

			BeanUtils.copyProperties(bookingResponse, response);


			return response ;
	
}


else {
	

	
	
eventFeign.addSeats(noOfSeat, bookingResponse.getEventId());
	
bookingResponse.setNumberOfSeats(bookingResponse.getNumberOfSeats()- noOfSeat);

if(bookingResponse.getNumberOfSeats()==0) {
	
	bookingResponse.setBookingStatus(BookingStatus.CANCELLED);
}

bookingResponse=

bRepo.save(bookingResponse);



BookingResponseDto response= BookingResponseDto.builder().build();

BeanUtils.copyProperties(bookingResponse, response);


return response ;
	
}
		
		
	}


}
