package com.md.app.dtos;

import lombok.Data;

@Data
public class CharacterDtoResponse {
	
	private Integer id;	
	private String name;
	private String status;
	private String species;
	private String type;
	private Integer episode_count;
	private LocationDtoResponse origin;	

}
