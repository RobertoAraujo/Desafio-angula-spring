package com.poshyweb.projeto.erros;

import java.util.Iterator;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javassist.tools.rmi.ObjectNotFoundException;

@ControllerAdvice
public class ResouceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandaErro>  objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
		StandaErro error = new StandaErro(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandaErro>  DataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request){
		StandaErro error = new StandaErro(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandaErro>  ValidaErro(MethodArgumentNotValidException e, ServletRequest request){
		ValidaErro error = new ValidaErro(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), 
				"Erro na validação dos campos");
		
		for (FieldError x: e.getBindingResult().getFieldErrors()) {
			error.addErros(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
