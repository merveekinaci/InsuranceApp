package com.merve.exception.management;

public class InvalidAuthenticationException extends Exception {

	private static final long serialVersionUID = -1512968406062966965L;

	private String message;

	public InvalidAuthenticationException(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
