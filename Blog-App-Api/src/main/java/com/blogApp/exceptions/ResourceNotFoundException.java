package com.blogApp.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private int fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
		super(String.format("%s not found with %s : %l", resourceName, fieldName, fieldValue ));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	

}
