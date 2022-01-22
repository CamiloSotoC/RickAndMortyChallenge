package com.md.app.interfaces;

import com.md.app.dtos.CharacterDtoResponse;
import com.md.app.models.Character;

public interface CharacterServiceInterface {
		
	public Character findByIdRaw(Integer id);		
	public CharacterDtoResponse findByIdDto(Integer id);

}
