package com.md.app.interfaces;

import com.md.app.models.Character;

public interface CharacterRepositoryInterface {

	Character findById(Integer id);
}
