package com.capg.fms.airport.service;

import com.capg.fms.airport.entity.AirportBean;
import com.capg.fms.airport.entity.AirportListBean;

public interface IAirportService {

	 public AirportBean addAirport(AirportBean airportBean);
	 public boolean deleteAirport(String airportCode);
	 public AirportListBean viewAllAirports();
	 public AirportBean viewAirportByCode(String airportCode);
    
    
}