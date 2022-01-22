package com.md.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.app.dtos.CharacterDtoResponse;
import com.md.app.interfaces.CharacterServiceInterface;
import com.md.app.interfaces.LocationServiceInterface;
import com.md.app.interfaces.RickAndMortyServiceInterface;
import com.md.app.models.Character;

@Service
public class RickAndMortyService implements RickAndMortyServiceInterface {

	@Autowired
	private CharacterServiceInterface characterService;
	@Autowired
	private LocationServiceInterface locationService;
	@Autowired
	private ModelMapper modelMapper;
	
	public CharacterDtoResponse findByIdDto(Integer id) {		
		Character character = characterService.findByIdRaw(id);		
		if (character == null)
			return null;
		if(character.getOrigin().getId() != null)	character.setOrigin(locationService.findByIdRaw(character.getOrigin().getId()));		
		CharacterDtoResponse characterDto = modelMapper.map(character, CharacterDtoResponse.class);
		characterDto.setEpisode_count(character.getEpisode().size());		
		return characterDto;
	}

}
