package com.md.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.app.dtos.CharacterDtoResponse;
import com.md.app.interfaces.CharacterRepositoryInterface;
import com.md.app.interfaces.CharacterServiceInterface;
import com.md.app.models.Character;

@Service
public class CharacterService implements CharacterServiceInterface {
	
	@Autowired
	private CharacterRepositoryInterface repository;
	@Autowired
	private LocationService locationService;
	@Autowired
	private ModelMapper modelMapper;
		
	public Character findById(Integer id) {
		Character character = repository.findById(id);
		return character;
	}
	
	public CharacterDtoResponse findByIdDto(Integer id) {
		System.out.println(id);
		Character character = findById(id);
	
		if(character.getOrigin().getId() != null)	character.setOrigin(locationService.findById(character.getOrigin().getId()));		
		if(character.getLocation().getId() !=null)	character.setLocation(locationService.findById(character.getLocation().getId()));		
		CharacterDtoResponse characterDto = modelMapper.map(character, CharacterDtoResponse.class);
		characterDto.setEpisode_count(character.getEpisode().size());
		
		return characterDto;
	}
	
	public Character findByIdFull(Integer id) {
		Character character = repository.findById(id);
		
		//if(!character.getOrigin().getUrl().isBlank())	character.setOrigin(locationService.findByUrl(character.getOrigin().getUrl()));
		//if(!character.getLocation().getUrl().isBlank())	character.setLocation(locationService.findByUrl(character.getLocation().getUrl()));		
		if(character.getOrigin().getId() != null)	character.setOrigin(locationService.findById(character.getOrigin().getId()));		
		if(character.getLocation().getId() !=null)	character.setLocation(locationService.findById(character.getLocation().getId()));
			
		return character;
	}

}
