package com.example.blogapp.blogexception;

public class ResourceNotFoundException extends RuntimeException{

	String resourcename;
	String fieldname;
	int fieldvalue;
	public ResourceNotFoundException(String resourcename, String fieldname, int fieldvalue) {
		super(String.format("%s not found with %s:%d",resourcename,fieldname,fieldvalue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}
}
