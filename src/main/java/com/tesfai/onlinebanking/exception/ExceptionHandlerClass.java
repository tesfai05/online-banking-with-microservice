package com.tesfai.onlinebanking.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(NotSufficientBalance.class)
	public String exceptionNotSufficientBalance(NotSufficientBalance exception) {
		return exception.getMessage();
	}
	@ExceptionHandler(UserAlreadyExist.class)
	public String exceptionUserAlreadyExist(UserAlreadyExist exception) {
		return exception.getMessage();
	}

	@ExceptionHandler(UnsupportedData.class)
	public String exceptionUnsupportedData(UnsupportedData exception) {
		return exception.getMessage();
	}

	@ExceptionHandler(NoAccountFoundException.class)
	public String exceptionNoAccountFoundException(NoAccountFoundException exception) {
		
		return exception.getMessage();
	}
}
