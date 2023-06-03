package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExcpetionHandler {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetail> UserExceptionHandler(UserException ue, WebRequest req) {
		MyErrorDetail errorDetail = new MyErrorDetail();
		errorDetail.setTimeStamp(LocalDateTime.now());
		errorDetail.setMessage(ue.getMessage());
		errorDetail.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ProfileException.class)
	public ResponseEntity<MyErrorDetail> ProfileExceptionHandler(ProfileException pe, WebRequest req) {
		MyErrorDetail errorDetail = new MyErrorDetail();
		errorDetail.setTimeStamp(LocalDateTime.now());
		errorDetail.setMessage(pe.getMessage());
		errorDetail.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class) 
	public ResponseEntity<MyErrorDetail> AllExceptionHandler(Exception e, WebRequest req) {
		MyErrorDetail errorDetail = new MyErrorDetail();
		errorDetail.setTimeStamp(LocalDateTime.now());
		errorDetail.setMessage(e.getMessage());
		errorDetail.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> ValidationHandler(MethodArgumentNotValidException mve) {
		MyErrorDetail errorDetail = new MyErrorDetail();
		errorDetail.setTimeStamp(LocalDateTime.now());
		errorDetail.setMessage("Validation error");
		errorDetail.setDetails(mve.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);

	}
}
