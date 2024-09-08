package com.pujitha.springboot.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public String recordNotFoundException(RecordNotFoundException ex)
	{
		return ex.getMessage();
	}
}
