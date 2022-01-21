package com.md.app.models;

import java.sql.Timestamp;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

	private Integer id;	
	private String name;
	private String type;		
	private String dimension;	
	private ArrayList<String> residents;
	private String url;
	private Timestamp created;
	
	
	public void setIdByUrl() {
		if(!url.isBlank()) {			
			String[] urlArray = url.split("/");
			setId(Integer.parseInt(urlArray[urlArray.length-1]));			
		}				
	}
}
