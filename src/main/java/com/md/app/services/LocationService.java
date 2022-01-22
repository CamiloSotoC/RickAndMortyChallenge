package com.md.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.app.dtos.LocationDtoResponse;
import com.md.app.interfaces.LocationRepositoryInterface;
import com.md.app.interfaces.LocationServiceInterface;
import com.md.app.models.Location;

@Service
public class LocationService implements LocationServiceInterface{
	
	@Autowired
	private LocationRepositoryInterface repository;
	@Autowired
	private ModelMapper modelMapper;

		
	public Location findByUrlRaw(String url) {
		return repository.findByUrl(url);
	}
	
	public Location findByIdRaw(Integer id) {
		return repository.findById(id);
	}
	
	public LocationDtoResponse findByIdDto(Integer id) {
		Location location = repository.findById(id);
		if(location == null)
			return null;
		LocationDtoResponse locationDto = modelMapper.map(location, LocationDtoResponse.class);
		return locationDto;		
	}


}
