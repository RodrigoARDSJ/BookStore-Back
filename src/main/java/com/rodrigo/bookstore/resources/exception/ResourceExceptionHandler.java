package com.rodrigo.bookstore.resources.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rodrigo.bookstore.exception.DataIntegrityVioletionException;
import com.rodrigo.bookstore.exception.ObjNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjNotFoundException.class)
	public ResponseEntity<StandardError> objNotFoundException(ObjNotFoundException e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityVioletionException.class)
	public ResponseEntity<StandardError> DataIntegrityVioletionException(DataIntegrityVioletionException e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
