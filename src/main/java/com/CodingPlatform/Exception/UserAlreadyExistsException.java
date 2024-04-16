package com.CodingPlatform.Exception;

public class UserAlreadyExistsException extends RuntimeException {

	/**
	* 
	*/
	private static final long serialVersionUID = 2018053307229428645L;
	private String message;

	public UserAlreadyExistsException() {
	}

	public UserAlreadyExistsException(String msg) {
		super(msg);
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
