package com.md.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.md.app.models.Character;
import com.md.app.services.CharacterService;

@RestController
@RequestMapping("/character")
public class CharacterController {
	
	@Autowired
	private CharacterService service;
			
	@GetMapping("/{id}")	
	public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {		
		Character result = service.findById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}

}
