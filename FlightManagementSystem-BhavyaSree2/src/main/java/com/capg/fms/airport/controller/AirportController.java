package com.capg.fms.airport.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.airport.entity.AirportBean;
import com.capg.fms.airport.entity.AirportListBean;
import com.capg.fms.airport.service.IAirportService;

@RestController
@RequestMapping("/airport")
@CrossOrigin(origins="http://localhost:4200")
public class AirportController {
	
	@Autowired 
	private IAirportService airportservice;
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> addAirport(@Valid @RequestBody AirportBean airportBean){
		airportservice.addAirport(airportBean);
		ResponseEntity<Boolean> responseEntity=new ResponseEntity(true,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/delete/{airportCode}")
	public ResponseEntity<String> deleteAirport(@PathVariable String airportCode) {
		
			airportservice.deleteAirport(airportCode);
			ResponseEntity<String> responseEntity = new ResponseEntity(true,HttpStatus.OK);
		    System.out.println("response entity=" + responseEntity);
			return responseEntity;
		
	}  
	
	@GetMapping("/all")
	public ResponseEntity<AirportListBean> getAllAirports(){
		AirportListBean list=airportservice.viewAllAirports();
		return new ResponseEntity<AirportListBean>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/{airportcode}")
	public ResponseEntity<AirportBean> viewAiportByCode(@PathVariable ("airportcode") String airportCode ){
		AirportBean airportBean=airportservice.viewAirportByCode(airportCode);	
		return new ResponseEntity<AirportBean>(airportBean,HttpStatus.OK);

	}
	
	@ExceptionHandler(Exception.class)
    public String inValidInput(Exception e)
    {
   	 return e.getMessage();
    }
	

}
