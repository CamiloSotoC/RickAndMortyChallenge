package com.md.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.md.app.interfaces.LocationRepositoryInterface;
import com.md.app.models.Location;

@SpringBootTest
public class LocationRepositoryTest {

	@Autowired
	private LocationRepositoryInterface locationRpository;
	
	@Test
	void findByUrl() {
		Location location1 = locationRpository.findByUrl("https://rickandmortyapi.com/api/location/1");			
		assertTrue(location1.getId().equals(1));		
		assertTrue(location1.getName().equals("Earth (C-137)"));
		//assertTrue(location1.getType().equals("Planet"));
		assertTrue(location1.getDimension().equals("Dimension C-137"));
		assertTrue(location1.getResidents().size() == 27 );
		assertTrue(location1.getUrl().equals("https://rickandmortyapi.com/api/location/1"));
		
		Location location2 = locationRpository.findByUrl("https://rickandmortyapi.com/api/location/2");
		assertTrue(location2.getId().equals(2));
		assertTrue(location2.getName().equals("Abadango"));
		//assertTrue(location2.getType().equals("Cluster"));		
		assertTrue(location2.getDimension().equals("unknown"));
		assertTrue(location2.getResidents().size() == 1 );
		assertTrue(location2.getUrl().equals("https://rickandmortyapi.com/api/location/2"));
		
		Location location100 = locationRpository.findByUrl("https://rickandmortyapi.com/api/location/100");
		assertTrue(location100.getId().equals(100));
		assertTrue(location100.getName().equals("Ricks’s Story"));
		//assertTrue(location100.getType().equals("Diegesis"));		
		assertTrue(location100.getDimension().equals("Replacement Dimension"));
		assertTrue(location100.getResidents().size() == 6 );
		assertTrue(location100.getUrl().equals("https://rickandmortyapi.com/api/location/100"));
	}
	
	@Test
	void findById() {
		Location location1 = locationRpository.findById(1);			
		assertTrue(location1.getId().equals(1));		
		assertTrue(location1.getName().equals("Earth (C-137)"));
		//assertTrue(location1.getType().equals("Planet"));
		assertTrue(location1.getDimension().equals("Dimension C-137"));
		assertTrue(location1.getResidents().size() == 27 );
		assertTrue(location1.getUrl().equals("https://rickandmortyapi.com/api/location/1"));
		
		Location location2 = locationRpository.findById(2);
		assertTrue(location2.getId().equals(2));
		assertTrue(location2.getName().equals("Abadango"));
		//assertTrue(location2.getType().equals("Cluster"));		
		assertTrue(location2.getDimension().equals("unknown"));
		assertTrue(location2.getResidents().size() == 1 );
		assertTrue(location2.getUrl().equals("https://rickandmortyapi.com/api/location/2"));
		
		Location location100 = locationRpository.findById(100);
		assertTrue(location100.getId().equals(100));
		assertTrue(location100.getName().equals("Ricks’s Story"));
		//assertTrue(location100.getType().equals("Diegesis"));		
		assertTrue(location100.getDimension().equals("Replacement Dimension"));
		assertTrue(location100.getResidents().size() == 6 );
		assertTrue(location100.getUrl().equals("https://rickandmortyapi.com/api/location/100"));
	}
}
