package com.md.app.interfaces;

import com.md.app.dtos.CharacterDtoResponse;

public interface RickAndMortyServiceInterface {

	public CharacterDtoResponse findByIdDto(Integer id);
}
