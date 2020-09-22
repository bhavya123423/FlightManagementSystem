package com.capg.fms.airport.exceptions;

public class AirportCodeNotFoundException extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	public AirportCodeNotFoundException() {
		super();
	}
	public AirportCodeNotFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}

}