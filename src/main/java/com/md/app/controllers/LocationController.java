package com.md.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.md.app.dtos.LocationDtoResponse;
import com.md.app.interfaces.LocationServiceInterface;
import com.md.app.models.Location;


@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private LocationServiceInterface service;
		
	@GetMapping("/{id}")	
	public ResponseEntity<?> findByIdDto(@Valid @PathVariable Integer id) {		
		LocationDtoResponse result = service.findByIdDto(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	@GetMapping("/full/{id}")	
	public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {		
		Location result = service.findById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}

}
