package com.md.app.interfaces;

import com.md.app.models.Location;

public interface LocationRepositoryInterface {
	
	Location findById(Integer id);
	Location findByUrl(String url);
	

}
