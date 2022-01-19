package com.md.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.app.dtos.CharacterDtoResponse;
import com.md.app.interfaces.CharacterRepositoryInterface;
import com.md.app.models.Character;

@Service
public class CharacterService{
	
	@Autowired
	private CharacterRepositoryInterface repository;
	@Autowired
	private LocationService locationService;
	@Autowired
	private ModelMapper modelMapper;
	
	public Character findByIdFull(Integer id) {		
		Character result = repository.findById(id);		
		result.setOrigin(locationService.findByUrlFull(result.getOrigin().getUrl()));
		result.setLocation(locationService.findByUrlFull(result.getLocation().getUrl()));
		return result;
	}
	
	public CharacterDtoResponse findById(Integer id) {
		Character character = repository.findById(id);
		CharacterDtoResponse characterDto = modelMapper.map(character, CharacterDtoResponse.class);
		characterDto.setOrigin(locationService.findByUrl(characterDto.getOrigin().getUrl()));
		characterDto.setEpisode_count(character.getEpisode().size());
		return characterDto;
	}
	
	

}
