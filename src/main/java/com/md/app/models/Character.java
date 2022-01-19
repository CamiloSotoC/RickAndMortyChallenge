package com.md.app.models;

import java.sql.Timestamp;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {
	
	private Integer id;	
	private String name;
	private String status;
	private String species;
	private String type;
	private String gender;
	private Location origin;
	private Location location;
	private String image;
	private ArrayList<String> episode;
	private String url;
	private Timestamp created;	

}
