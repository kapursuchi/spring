package com.luv2code.springdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min = 1, message="is required")
	private String lastName;
	
	//hello
	private String freePasses;
	
	public String getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(String freePasses) {
		this.freePasses = freePasses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
