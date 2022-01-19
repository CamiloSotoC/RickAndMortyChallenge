package com.md.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.app.interfaces.LocationRepositoryInterface;
import com.md.app.models.Location;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepositoryInterface repository;
		
	public Location findById(Integer id) {		
		return repository.findById(id);
	}
	
	public Location findByUrl(String url) {		
		return repository.findByUrl(url);
	}

}
