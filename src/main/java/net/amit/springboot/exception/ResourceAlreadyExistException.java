package net.amit.springboot.exception;

public class ResourceAlreadyExistException extends RuntimeException {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object fieldValue;
	public ResourceAlreadyExistException(Object fieldValue) {
		super(String.format("Reaource Already exist with id %s",fieldValue));
		this.fieldValue = fieldValue;
	}
	

}
