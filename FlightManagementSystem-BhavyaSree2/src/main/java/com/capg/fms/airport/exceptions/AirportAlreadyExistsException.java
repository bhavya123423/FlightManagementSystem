package com.capg.fms.airport.exceptions;

public class AirportAlreadyExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public AirportAlreadyExistsException() {
		super();
	}
	public AirportAlreadyExistsException(String exceptionMessage) {
		super(exceptionMessage);
	} 

}