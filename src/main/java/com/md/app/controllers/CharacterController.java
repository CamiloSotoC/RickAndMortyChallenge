package com.md.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.md.app.dtos.CharacterDtoResponse;
import com.md.app.models.Character;
import com.md.app.services.CharacterService;

@RestController
@RequestMapping("/character")
public class CharacterController {
	
	@Autowired
	private CharacterService service;
	
	@GetMapping("/full/{id}")	
	public ResponseEntity<?> findByIdFull(@Valid @PathVariable Integer id) {		
		Character result = service.findByIdFull(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
			
	@GetMapping("/{id}")	
	public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {		
		CharacterDtoResponse result = service.findByIdDto(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}

}
