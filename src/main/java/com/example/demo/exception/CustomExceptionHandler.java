package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {
	
	private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    
    
    @ExceptionHandler(PolicyNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handlePolicyotFoundException(PolicyNotFoundException exception,WebRequest request)
    {
    	List<String> details=new ArrayList<>();
    	details.add(exception.getLocalizedMessage());
    	ErrorResponse error=new ErrorResponse(INCORRECT_REQUEST, details);
    	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    	
    }
    
   
}
