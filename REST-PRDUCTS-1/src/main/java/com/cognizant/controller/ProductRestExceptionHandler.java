package com.cognizant.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.exception.ApiError;
import com.cognizant.exception.ProductNotFoundException;

@RestController
@RestControllerAdvice
public class ProductRestExceptionHandler {
     @ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<ApiError> handleProductNotFoundException()
	{
		ApiError aError = new ApiError();
		aError.setErrorCode(404);
		aError.setErrorDate(new Date());
		aError.setErrorMsg("Product not found");
		return new ResponseEntity<>(aError,HttpStatus.BAD_REQUEST);
	}
}
