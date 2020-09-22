package com.capg.fms.airport.entity;

import java.util.List;

public class AirportListBean {
	   
	private List<AirportBean> airportList;

	public List<AirportBean> getAirportList() {
		return airportList;
	}

	public void setAirportList(List<AirportBean> airportList) {
		this.airportList = airportList;
	}

	@Override
	public String toString() {
		return "AirportList [airportList=" + airportList + "]";
	}

	public AirportListBean(List<AirportBean> airportList) {
		super();
		this.airportList = airportList;
	}

	public AirportListBean() {
		super();
	}
}