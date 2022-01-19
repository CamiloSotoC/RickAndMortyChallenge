package com.md.app.dtos;

import java.util.ArrayList;

import lombok.Data;

@Data
public class LocationDtoResponse {
	
	private String name;
	private String url;
	private String dimension;	
	private ArrayList<String> residents;
	
}
