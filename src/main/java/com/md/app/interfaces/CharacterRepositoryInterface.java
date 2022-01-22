package com.md.app.interfaces;

import com.md.app.models.Character;


public interface CharacterRepositoryInterface {

	public Character findById(Integer id);
}
