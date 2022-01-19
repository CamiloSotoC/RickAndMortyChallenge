package com.md.app.respositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.md.app.interfaces.CharacterRepositoryInterface;
import com.md.app.models.Character;

@Repository
public class CharacterApiRepository implements CharacterRepositoryInterface {
	
	@Value("${api.character.url}")
	private String url;

	@Override
	public Character findById(Integer id) {		
		RestTemplate restTemplate = new RestTemplate();
		Character result = restTemplate.getForObject(url+id, Character.class);
		return result;		
	}
	
	@Override
	public Character findByUrl(String url) {		
		RestTemplate restTemplate = new RestTemplate();
		Character result = restTemplate.getForObject(url, Character.class);
		return result;		
	}	

}
