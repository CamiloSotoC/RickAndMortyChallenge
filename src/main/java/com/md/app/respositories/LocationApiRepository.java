package com.md.app.respositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.md.app.interfaces.LocationRepositoryInterface;
import com.md.app.models.Location;

@Repository
public class LocationApiRepository implements LocationRepositoryInterface{
	
	@Autowired
	private RestTemplate restTemplate;
	@Value("${api.location.url}")
	private String url;
	
	@Override
	public Location findById(Integer id) {
		return restTemplate.getForObject(url+id, Location.class);		
	}
	
	@Override
	public Location findByUrl(String url) {
		return restTemplate.getForObject(url, Location.class);
	}

}
