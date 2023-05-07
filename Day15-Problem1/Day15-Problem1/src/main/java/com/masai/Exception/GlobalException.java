package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandller(ProductException pException, WebRequest wres){
		
		MyErrorDetails myError = new MyErrorDetails();
		
		myError.setDateTime(LocalDateTime.now());
		myError.setMessage(pException.getMessage());
		myError.setDescription(wres.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myError,HttpStatus.BAD_REQUEST);
		
	}
	
}
