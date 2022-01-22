package com.md.app.controllers;

import java.net.ConnectException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.md.app.models.ErrorResponse;

@RestControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<?> handleNumberFormatException(NumberFormatException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Invalid number format"));		
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Argument is not of the expected type"));		
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<?> handleHttpClientErrorException(HttpClientErrorException e) throws JacksonException  {
		return ResponseEntity.status(e.getStatusCode()).body(new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class));				
	}	
	
	@ExceptionHandler(JacksonException.class)
	public ResponseEntity<?> handleJacksonException(JacksonException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Error convert String to Json"));		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<?> handleNoHandlerFoundException(NoHandlerFoundException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("There is nothing here"));		
	}
	
	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<?> handleConnectException(ConnectException e) {		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(e.getMessage()));		
	}

}
