package com.example.restfulservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception e,WebRequest req){
	
		ExceptionResponse res=new ExceptionResponse(new Date(), e.getMessage(), req.getDescription(true));
		return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException e,WebRequest req){
	
		ExceptionResponse res=new ExceptionResponse(new Date(), e.getMessage(), req.getDescription(true));
		return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse res=new ExceptionResponse(new Date(), ex.getMessage(),ex.getBindingResult().toString());
		return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
	}
}
