package com.md.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.md.app.dtos.CharacterDtoResponse;
import com.md.app.services.CharacterService;
import com.md.app.services.RickAndMortyService;

@SpringBootTest
public class RickAndMortyServiceTest {
	
	@Autowired
	private RickAndMortyService rickAndMortyService;
	
	@Test
	void findByIdDto() {
		CharacterDtoResponse character1 = rickAndMortyService.findByIdDto(1);		
		assertTrue(character1.getId().equals(1));
		assertTrue(character1.getName().equals("Rick Sanchez"));
		assertTrue(character1.getStatus().equals("Alive"));
		assertTrue(character1.getSpecies().equals("Human"));
		assertTrue(character1.getType().equals(""));
		assertTrue(character1.getEpisode_count().equals(51));
		assertTrue(character1.getOrigin().getName().equals("Earth (C-137)"));
		assertTrue(character1.getOrigin().getUrl().equals("https://rickandmortyapi.com/api/location/1"));
		assertTrue(character1.getOrigin().getDimension().equals("Dimension C-137"));		
		assertTrue(character1.getOrigin().getResidents().size() == 27);
		
		CharacterDtoResponse character2 = rickAndMortyService.findByIdDto(2);		
		assertTrue(character2.getId().equals(2));
		assertTrue(character2.getName().equals("Morty Smith"));
		assertTrue(character2.getStatus().equals("Alive"));
		assertTrue(character2.getSpecies().equals("Human"));
		assertTrue(character2.getType().equals(""));
		assertTrue(character2.getEpisode_count().equals(51));
		assertTrue(character2.getOrigin().getName().equals("unknown"));
		assertTrue(character2.getOrigin().getUrl().equals(""));		
		assertTrue(character2.getOrigin().getDimension() == null);		
		assertTrue(character2.getOrigin().getResidents() == null);
		
		CharacterDtoResponse character100 = rickAndMortyService.findByIdDto(100);		
		assertTrue(character100.getId().equals(100));
		assertTrue(character100.getName().equals("Bubonic Plague"));
		assertTrue(character100.getStatus().equals("Dead"));
		assertTrue(character100.getSpecies().equals("Disease"));
		assertTrue(character100.getType().equals(""));
		assertTrue(character100.getEpisode_count().equals(1));
		assertTrue(character100.getOrigin().getName().equals("Anatomy Park"));
		assertTrue(character100.getOrigin().getUrl().equals("https://rickandmortyapi.com/api/location/5"));
		assertTrue(character100.getOrigin().getDimension().equals("Dimension C-137"));		
		assertTrue(character100.getOrigin().getResidents().size() == 11);
		
	}

}
