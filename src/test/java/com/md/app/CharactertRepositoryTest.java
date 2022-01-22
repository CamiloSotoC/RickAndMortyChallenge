package com.md.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.md.app.interfaces.CharacterRepositoryInterface;
import com.md.app.models.Character;

@SpringBootTest
public class CharactertRepositoryTest {
	
	@Autowired
	private CharacterRepositoryInterface characterRpository;
	
	@Test
	void FindById() {
		Character character1 = characterRpository.findById(1);		
		
		assertTrue(character1.getId().equals(1));
		assertTrue(character1.getName().equals("Rick Sanchez"));
		assertTrue(character1.getStatus().equals("Alive"));
		assertTrue(character1.getSpecies().equals("Human"));
		assertTrue(character1.getType().equals(""));
		//assertTrue(character1.getGender().equals("Male"));
		assertTrue(character1.getOrigin().getId().equals(1));
		assertTrue(character1.getOrigin().getName().equals("Earth (C-137)"));
		assertTrue(character1.getOrigin().getUrl().equals("https://rickandmortyapi.com/api/location/1"));
		assertTrue(character1.getLocation().getId().equals(3));
		assertTrue(character1.getLocation().getName().equals("Citadel of Ricks"));
		assertTrue(character1.getLocation().getUrl().equals("https://rickandmortyapi.com/api/location/3"));
		//assertTrue(character1.getImage().equals("https://rickandmortyapi.com/api/character/avatar/1.jpeg"));		
		assertTrue(character1.getEpisode().size()==51);
		//assertTrue(character1.getUrl().equals("https://rickandmortyapi.com/api/character/1"));
		
		Character character2 = characterRpository.findById(2);		
		assertTrue(character2.getId().equals(2));
		assertTrue(character2.getName().equals("Morty Smith"));
		assertTrue(character2.getStatus().equals("Alive"));
		assertTrue(character2.getSpecies().equals("Human"));
		assertTrue(character2.getType().equals(""));
		//assertTrue(character2.getGender().equals("Male"));
		assertTrue(character2.getOrigin().getId() == null );
		assertTrue(character2.getOrigin().getName().equals("unknown"));
		assertTrue(character2.getOrigin().getUrl().equals(""));
		assertTrue(character2.getLocation().getId().equals(3));
		assertTrue(character2.getLocation().getName().equals("Citadel of Ricks"));
		assertTrue(character2.getLocation().getUrl().equals("https://rickandmortyapi.com/api/location/3"));
		//assertTrue(character2.getImage().equals("https://rickandmortyapi.com/api/character/avatar/2.jpeg"));
		assertTrue(character2.getEpisode().size()==51);
		//assertTrue(character2.getUrl().equals("https://rickandmortyapi.com/api/character/2"));
		
		Character character100 = characterRpository.findById(100);		
		assertTrue(character100.getId().equals(100));
		assertTrue(character100.getName().equals("Bubonic Plague"));
		assertTrue(character100.getStatus().equals("Dead"));
		assertTrue(character100.getSpecies().equals("Disease"));
		assertTrue(character100.getType().equals(""));
		//assertTrue(character100.getGender().equals("unknown"));
		assertTrue(character100.getOrigin().getId().equals(5));
		assertTrue(character100.getOrigin().getName().equals("Anatomy Park"));
		assertTrue(character100.getOrigin().getUrl().equals("https://rickandmortyapi.com/api/location/5"));
		assertTrue(character100.getLocation().getId().equals(5));
		assertTrue(character100.getLocation().getName().equals("Anatomy Park"));
		assertTrue(character100.getLocation().getUrl().equals("https://rickandmortyapi.com/api/location/5"));
		//assertTrue(character100.getImage().equals("https://rickandmortyapi.com/api/character/avatar/100.jpeg"));
		assertTrue(character100.getEpisode().size()==1);
		//assertTrue(character100.getUrl().equals("https://rickandmortyapi.com/api/character/100"));
	}

}
