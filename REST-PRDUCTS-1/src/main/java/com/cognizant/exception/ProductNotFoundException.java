package com.cognizant.exception;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException() {
		super();
		
	}

	public ProductNotFoundException(String message) {
		super(message);
	
	}

	private static final long serialVersionUID = 1L;

}
