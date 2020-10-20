package com.tesfai.onlinebanking.exception;

public class UserAlreadyExist extends Exception {

	private static final long serialVersionUID = -5333361639095391319L;

	public UserAlreadyExist() {
	}

	public UserAlreadyExist(String message) {
		super(message);
	}

}
