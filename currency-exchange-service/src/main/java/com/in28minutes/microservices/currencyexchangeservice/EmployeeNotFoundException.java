package com.in28minutes.microservices.currencyexchangeservice;

public class EmployeeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EmployeeNotFoundException(String string) {
	    super("Could not find employee " + string);
	  }
}
