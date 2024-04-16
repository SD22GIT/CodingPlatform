package com.CodingPlatform.Exception;

public class InvalidScoreException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7379030878124377025L;
	private String message;

	public InvalidScoreException() {
	}

	public InvalidScoreException(String msg) {
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
