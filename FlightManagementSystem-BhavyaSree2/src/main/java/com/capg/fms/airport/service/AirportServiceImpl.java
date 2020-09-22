package com.capg.fms.airport.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.airport.entity.AirportBean;
import com.capg.fms.airport.entity.AirportListBean;
import com.capg.fms.airport.exceptions.AirportAlreadyExistsException;
import com.capg.fms.airport.exceptions.AirportCodeNotFoundException;
import com.capg.fms.airport.repository.AirportRepo;

@Service
@Transactional

public class AirportServiceImpl implements IAirportService {
	
	@Autowired(required=true)
    AirportRepo airportRepo;
	@Override
	public AirportBean addAirport(AirportBean airportBean) {
		System.out.println(airportBean);
		if(airportRepo.existsById(airportBean.getAirportCode()) || airportRepo.existsById(airportBean.getAirportName())) {
	
	   throw new AirportAlreadyExistsException("Airport with the given code or the given name already exists");
		}
		return airportRepo.save(airportBean);
	}

	@Override
	public boolean deleteAirport(String airportCode) {
		if(airportRepo.existsById(airportCode)) { 
			airportRepo.deleteById(airportCode);
		}
		else
		{
			System.out.println(airportCode);
			throw new AirportCodeNotFoundException("Airport with airportcode  "+airportCode+"  not Found");
		}
			return true;
	}
	

	@Override
	public AirportListBean viewAllAirports() {
		return new AirportListBean(airportRepo.findAll());
	}

    @Override
	public AirportBean viewAirportByCode(String airportCode) {

		  if(!airportRepo.existsById(airportCode)) { 
			  System.out.println(airportCode);
		  throw new AirportCodeNotFoundException("Airport with Airportcode  "+airportCode+"  not Found");
		 }
		 
		return airportRepo.getOne(airportCode);
	}

	

}
