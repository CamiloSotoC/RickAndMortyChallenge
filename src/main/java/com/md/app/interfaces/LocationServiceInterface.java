package com.md.app.interfaces;

import com.md.app.dtos.LocationDtoResponse;
import com.md.app.models.Location;

public interface LocationServiceInterface {

	public Location findByUrl(String url) ;	
	public Location findById(Integer id);	
	public LocationDtoResponse findByIdDto(Integer id);
	
}
