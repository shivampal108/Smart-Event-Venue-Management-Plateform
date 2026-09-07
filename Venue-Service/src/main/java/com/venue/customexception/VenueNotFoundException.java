package com.venue.customexception;

public class VenueNotFoundException  extends RuntimeException{
	
	
	public VenueNotFoundException(String msg) {
		
		super(msg);
		
	}

}
