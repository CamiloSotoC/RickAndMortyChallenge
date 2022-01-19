package com.md.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.app.dtos.CharacterDtoResponse;
import com.md.app.dtos.LocationDtoResponse;
import com.md.app.interfaces.LocationRepositoryInterface;
import com.md.app.models.Character;
import com.md.app.models.Location;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepositoryInterface repository;
	@Autowired
	private ModelMapper modelMapper;
		
	public Location findByIdFull(Integer id) {		
		return repository.findById(id);
	}
	
	public Location findByUrlFull(String url) {		
		return repository.findByUrl(url);
	}
		
	public LocationDtoResponse findById(Integer id) {
		Location location = repository.findById(id);
		LocationDtoResponse locationDto = modelMapper.map(location, LocationDtoResponse.class);
		return locationDto;		
	}
	
	public LocationDtoResponse findByUrl(String url) {
		Location location = repository.findByUrl(url);
		LocationDtoResponse locationDto = modelMapper.map(location, LocationDtoResponse.class);
		return locationDto;		
	}

}
