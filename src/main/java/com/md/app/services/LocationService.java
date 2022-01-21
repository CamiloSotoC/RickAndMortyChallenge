package com.md.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.app.dtos.CharacterDtoResponse;
import com.md.app.dtos.LocationDtoResponse;
import com.md.app.interfaces.CharacterRepositoryInterface;
import com.md.app.interfaces.LocationRepositoryInterface;
import com.md.app.models.Character;
import com.md.app.models.Location;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepositoryInterface repository;
	@Autowired
	private ModelMapper modelMapper;

		
	public Location findByUrl(String url) {
		return repository.findByUrl(url);
	}
	public Location findById(Integer id) {
		return repository.findById(id);
	}
	
	public LocationDtoResponse findByIdDto(Integer id) {
		Location location = repository.findById(id);
		LocationDtoResponse locationDto = modelMapper.map(location, LocationDtoResponse.class);
		return locationDto;		
	}


}
