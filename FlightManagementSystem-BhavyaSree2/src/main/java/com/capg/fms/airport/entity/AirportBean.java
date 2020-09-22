package com.capg.fms.airport.entity;
 import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
 
@Entity
@Table(name="Airport_Spring")
public class AirportBean {
    
	@Id
	@NotEmpty(message="Airportcode is mandatory field.Please provide Airportcode")
	private String airportCode;
	
	@NotEmpty(message="Airportname is mandatory field.Please provide Airportname")
	@Size(min=4,message= "Name should have atleast:4 characters")
	private String airportName;
	
	@NotEmpty(message="AirportLocation is mandatory field.Please provide AirportLocation")
	@Size(min=4,message= "Name should have atleast:4 characters")
	private String airportLocation;
	
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	@Override
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", airportName=" + airportName + ", airportLocation="
				+ airportLocation + "]";
	}
	public AirportBean(String airportCode, String airportName, String airportLocation) {
		super();
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	public AirportBean() {
		super();
	}
	
	
}
