package com.masai.Exception;

public class FlatException extends RuntimeException {
	public FlatException() {
		super("Something went wrong");
	}
	
	public FlatException(String message) {
		super(message);
	}
}
