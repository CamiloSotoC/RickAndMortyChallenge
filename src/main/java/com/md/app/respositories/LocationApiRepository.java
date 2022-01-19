package com.md.app.respositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.md.app.interfaces.LocationRepositoryInterface;
import com.md.app.models.Location;

@Repository
public class LocationApiRepository implements LocationRepositoryInterface{
	
	@Value("${api.location.url}")
	private String url;
	
	@Override
	public Location findById(Integer id) {		
		RestTemplate restTemplate = new RestTemplate();
		Location result = restTemplate.getForObject(url+id, Location.class);
		return result;		
	}
	
	@Override
	public Location findByUrl(String url) {		
		RestTemplate restTemplate = new RestTemplate();
		Location result = restTemplate.getForObject(url, Location.class);
		return result;		
	}

}
