package com.booking.customexception;

public class NoAvilableSeatException  extends RuntimeException{
	
	
	public NoAvilableSeatException(String msg) {
	super(msg);
	}

}
