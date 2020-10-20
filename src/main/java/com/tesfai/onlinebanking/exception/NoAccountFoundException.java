package com.tesfai.onlinebanking.exception;

public class NoAccountFoundException extends Exception {
	
	private static final long serialVersionUID = 9202818538761252422L;

	public NoAccountFoundException() {
	}

	public NoAccountFoundException(String message) {
		super(message);
	}
}
