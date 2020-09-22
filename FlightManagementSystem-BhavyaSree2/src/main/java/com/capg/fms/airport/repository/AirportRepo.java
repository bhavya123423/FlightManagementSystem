package com.capg.fms.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.fms.airport.entity.AirportBean;

public interface AirportRepo extends JpaRepository<AirportBean, String>{
	
}