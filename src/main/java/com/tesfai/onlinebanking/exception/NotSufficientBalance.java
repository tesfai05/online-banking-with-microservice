package com.tesfai.onlinebanking.exception;


public class NotSufficientBalance extends Exception {


	private static final long serialVersionUID = 418715565608203803L;

	public NotSufficientBalance() {
	}

	public NotSufficientBalance(String message) {
		super(message);
	}
}
