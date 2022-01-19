package com.md.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.app.interfaces.CharacterRepositoryInterface;
import com.md.app.models.Character;

@Service
public class CharacterService{
	
	@Autowired
	private CharacterRepositoryInterface respository;
	@Autowired
	private LocationService locationService;
	
	public Character findById(Integer id) {		
		Character result = respository.findById(id);		
		result.setOrigin(locationService.findByUrl(result.getOrigin().getUrl()));
		result.setLocation(locationService.findByUrl(result.getLocation().getUrl()));
		return result;
	}
	
	

}
