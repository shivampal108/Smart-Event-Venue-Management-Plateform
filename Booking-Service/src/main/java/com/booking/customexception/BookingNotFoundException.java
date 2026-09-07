package com.booking.customexception;

public class BookingNotFoundException extends RuntimeException {
	
	
	public BookingNotFoundException(String msg) {
		
		super(msg);
		
	}

}
