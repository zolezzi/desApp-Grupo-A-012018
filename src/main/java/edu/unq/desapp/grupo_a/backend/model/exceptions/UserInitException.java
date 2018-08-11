package edu.unq.desapp.grupo_a.backend.model.exceptions;

public class UserInitException extends ExceptionInInitializerError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;

	public UserInitException(String message) {

		this.message = message;
	}
	
	

}
