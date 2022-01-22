package com.md.app.respositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.md.app.interfaces.CharacterRepositoryInterface;
import com.md.app.models.Character;

@Repository
public class CharacterApiRepository implements CharacterRepositoryInterface {
	
	@Autowired
	private RestTemplate restTemplate;
	@Value("${api.character.url}")
	private String url;

	@Override
	public Character findById(Integer id) {		
		Character result = restTemplate.getForObject(url+id, Character.class);
		result.getOrigin().setIdByUrl();		
		result.getLocation().setIdByUrl();
		return result;
	}

}
