package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandlers {

	
	//for specific exception
	@ExceptionHandler(FlatException.class) 
	public ResponseEntity<MyErrorDetails> exceptionHandlerr(FlatException fe, WebRequest wr ) {
		
		MyErrorDetails details = new MyErrorDetails(LocalDateTime.now(), fe.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
		
	}
	
	//for all type of exception it will face
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler2(Exception ex, WebRequest wr) {
		
		MyErrorDetails details = new MyErrorDetails(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));

		
		return new ResponseEntity<MyErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}
}
