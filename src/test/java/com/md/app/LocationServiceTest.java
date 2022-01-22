package com.md.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.md.app.dtos.LocationDtoResponse;
import com.md.app.interfaces.LocationServiceInterface;

@SpringBootTest
public class LocationServiceTest {

	@Autowired
	private LocationServiceInterface locationService;
	
	
	@Test
	void findByIdDto() {
		LocationDtoResponse location1 = locationService.findByIdDto(1);
		assertTrue(location1.getName().equals("Earth (C-137)"));		
		assertTrue(location1.getDimension().equals("Dimension C-137"));
		assertTrue(location1.getResidents().size() == 27 );
		assertTrue(location1.getUrl().equals("https://rickandmortyapi.com/api/location/1"));
		
		LocationDtoResponse location2 = locationService.findByIdDto(2);		
		assertTrue(location2.getName().equals("Abadango"));		
		assertTrue(location2.getDimension().equals("unknown"));
		assertTrue(location2.getResidents().size() == 1 );
		assertTrue(location2.getUrl().equals("https://rickandmortyapi.com/api/location/2"));
		
		LocationDtoResponse location100 = locationService.findByIdDto(100);		
		assertTrue(location100.getName().equals("Ricks’s Story"));
		assertTrue(location100.getDimension().equals("Replacement Dimension"));
		assertTrue(location100.getResidents().size() == 6 );
		assertTrue(location100.getUrl().equals("https://rickandmortyapi.com/api/location/100"));
	}
}
