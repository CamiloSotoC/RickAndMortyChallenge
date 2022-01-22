package com.md.app.interfaces;

import com.md.app.models.Location;

public interface LocationRepositoryInterface {
	
	public Location findById(Integer id);
	public Location findByUrl(String url);
	

}
