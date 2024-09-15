package com.movies.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class handelExceptions {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handlemethodAgrsNotvlidException(MethodArgumentNotValidException ex ){
		Map<String, String> result = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String ferror = ((FieldError) error).getField();
			String message1 = error.getDefaultMessage();
			result.put(ferror, message1);
		});
		
		return new ResponseEntity<Map<String,String>>(result,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionhandle(Exception ex){
		String message2 = ex.getMessage();
		return new ResponseEntity<String>(message2,HttpStatus.BAD_REQUEST);
		
	}

}
