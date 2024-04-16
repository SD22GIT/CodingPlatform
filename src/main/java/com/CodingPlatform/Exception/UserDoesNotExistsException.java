package com.CodingPlatform.Exception;

public class UserDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4985605141160635660L;
	private String message;

	public UserDoesNotExistsException() {
	}

	public UserDoesNotExistsException(String msg) {
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
