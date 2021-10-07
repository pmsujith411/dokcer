package com.in28minutes.microservices.currencyexchangeservice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CurrencyExchangeAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	String EmployeeNotFoundHandler(EmployeeNotFoundException ex) {
		return ex.getMessage();
		
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException
	(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse respExpn =
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(respExpn, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	
	
}
