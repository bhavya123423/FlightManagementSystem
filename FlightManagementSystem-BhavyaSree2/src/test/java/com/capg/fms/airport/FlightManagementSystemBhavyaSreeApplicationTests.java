package com.capg.fms.airport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.fms.airport.entity.AirportBean;
import com.capg.fms.airport.repository.AirportRepo;
import com.capg.fms.airport.service.AirportServiceImpl;
import com.capg.fms.airport.service.IAirportService;

@RunWith(SpringRunner.class)
@SpringBootTest
class FlightManagementSystemBhavyaSreeApplicationTests {
	@Autowired
	private IAirportService airportservice;
	@MockBean
	AirportRepo airportRepo;

	@Test
	public void addAirportTest() {
		AirportBean airportBean = mock(AirportBean.class);
		airportservice.addAirport(airportBean);
		verify(airportRepo).save(airportBean);
	}

	@Test
	public void getAllAirports() {

		airportservice.viewAllAirports();
		verify(airportRepo).findAll();
	}

	@Test
	public void testAddAirport() {
		AirportBean airportBean = new AirportBean();
		airportBean.setAirportCode("3");
		airportBean.setAirportName("rajeevgandhi");
		airportBean.setAirportLocation("Hyderabad");
		Mockito.when(airportRepo.save(airportBean)).thenReturn(airportBean);
		assertThat(airportservice.addAirport(airportBean)).isEqualTo(airportBean);

	}

}
