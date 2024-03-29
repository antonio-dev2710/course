package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.DataBaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
///@ExceptionHandler(ResourceNotFoundException.class) essa anotation indica que esse metodo vai intercipitar qualquer exessão desse tipo que foi lançada e vai fzr o tratamento

//@ControllerAdvice: essa anotação vai interceptar as excessoes que ocorrerem
//para que esse objeto possa executar um tramento
@ControllerAdvice
public class ResourceExptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String errror = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError err = new StandardError(Instant.now(), status.value(), errror, e.getMessage(), request.getRequestURI());
		
		//retornar uma resposta personalizada
		
		return ResponseEntity.status(status).body(err);
		
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request){
		String errror = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError err = new StandardError(Instant.now(), status.value(), errror, e.getMessage(), request.getRequestURI());
		
		//retornar uma resposta personalizada
		
		return ResponseEntity.status(status).body(err);
		
	}

}
