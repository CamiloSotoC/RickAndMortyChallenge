package com.md.app.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.app.dtos.CharacterDtoResponse;
import com.md.app.interfaces.CharacterRepositoryInterface;
import com.md.app.models.Character;

@Service
public class CharacterService {
	
	@Autowired
	private CharacterRepositoryInterface repository;
	@Autowired
	private LocationService locationService;
	@Autowired
	private ModelMapper modelMapper;
		
	public Character findById(Integer id) {
		Character character = repository.findById(id);		
		character.setOrigin(locationService.findByUrl(character.getOrigin().getUrl()));
		character.setLocation(locationService.findByUrl(character.getLocation().getUrl()));
		return character;
	}
	
	public CharacterDtoResponse findByIdDto(Integer id) {
		Character character = findById(id);		
		CharacterDtoResponse characterDto = modelMapper.map(character, CharacterDtoResponse.class);
		characterDto.setEpisode_count(character.getEpisode().size());
		return characterDto;
	}

	
	
	

}
