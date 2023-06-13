package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import jakarta.validation.ValidationException;

@ControllerAdvice
public class GloblaException {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorPattern> handleUserException(UserException ue, WebRequest wr){
		
		MyErrorPattern me = new MyErrorPattern();
		
		me.setLocalDateTime(LocalDateTime.now());
		me.setMesseage(ue.getMessage());
		me.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorPattern>(me,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(TruckException.class)
	public ResponseEntity<MyErrorPattern> handleTruckException(TruckException ue, WebRequest wr){
		
		MyErrorPattern me = new MyErrorPattern();
		
		me.setLocalDateTime(LocalDateTime.now());
		me.setMesseage(ue.getMessage());
		me.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorPattern>(me,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorPattern> handleAllException(Exception ue, WebRequest wr){
		
		MyErrorPattern me = new MyErrorPattern();
		
		me.setLocalDateTime(LocalDateTime.now());
		me.setMesseage(ue.getMessage());
		me.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorPattern>(me,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<MyErrorPattern> handleValidationException(ValidationException ue, WebRequest wr){
		
		MyErrorPattern me = new MyErrorPattern();
		
		me.setLocalDateTime(LocalDateTime.now());
		me.setMesseage(ue.getMessage());
		me.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorPattern>(me,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorPattern> handleMethodExceptions(MethodArgumentNotValidException se){
		
		MyErrorPattern me = new MyErrorPattern();
		
		me.setLocalDateTime(LocalDateTime.now());
		me.setDescription(se.getBindingResult().getFieldError().getDefaultMessage());
		me.setMesseage("Validation Error"); // clear exception from IA
		
		return new ResponseEntity<MyErrorPattern>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchMethodException.class)
	public ResponseEntity<MyErrorPattern> handleNoMethodExceptions(MethodArgumentNotValidException se){
		
		MyErrorPattern me = new MyErrorPattern();
		
		me.setLocalDateTime(LocalDateTime.now());
		me.setDescription(se.getBindingResult().getFieldError().getDefaultMessage());
		me.setMesseage("Validation Error"); // clear exception from IA
		
		return new ResponseEntity<MyErrorPattern>(me,HttpStatus.BAD_REQUEST);
	}
	
	
}
