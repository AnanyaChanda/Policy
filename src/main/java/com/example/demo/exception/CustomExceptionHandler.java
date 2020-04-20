package com.example.demo.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class CustomExceptionHandler {
	
	private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    private String INVALID_INPUT="INVALID_INPUT";
    
    /**
   	 * Exception handling for incorrect field input 
   	 * @param 
   	 * @return
   	 */
   	  @ExceptionHandler(MethodArgumentNotValidException.class) 
   	  public final ResponseEntity<Map<String, String>> handleMethodArgumentValidityException2(MethodArgumentNotValidException
   	  exception) {
   		  
   		  Map<String, String> errors = new HashMap<>();
   	      exception.getBindingResult().getAllErrors().forEach((error) -> { String
   	      fieldName = ((FieldError) error).getField(); String errorMessage =
   	      error.getDefaultMessage(); errors.put(fieldName, errorMessage); }); 
   	      return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
   	  }
    
    
    /**
	 * Exception handling for requested policy which does not exist
	 * @param 
	 * @return
	 */
    @ExceptionHandler(PolicyNotFoundException.class)
    public final ResponseEntity<PolicyErrorResponse> handlePolicyotFoundException(PolicyNotFoundException exception)
    {
    	List<String> details=new ArrayList<>();
    	details.add(exception.getLocalizedMessage());
    	int status=HttpStatus.NOT_FOUND.value();
    	String message=INCORRECT_REQUEST;
    	PolicyErrorResponse error=new PolicyErrorResponse(message, details, status);
    	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    	
    }
    
    
    /**
	 * Exception handling for incorrect input in the request parameter
	 * @param 
	 * @return
	 */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<PolicyErrorResponse> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException exception)
    {
    	List<String> details=new ArrayList<>();
    	details.add("Please enter request parameter in to corrrect format");
    	details.add(exception.getLocalizedMessage());
    	int status=HttpStatus.BAD_REQUEST.value();
    	String message=INVALID_INPUT;
    	PolicyErrorResponse error=new PolicyErrorResponse(message, details, status);
    	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    	
    }
    
   
    /**
	 * Exception handling for any bad request from user side 
	 * @param 
	 * @return
	 */
    @ExceptionHandler
    public final ResponseEntity<PolicyErrorResponse> handleException(Exception exception)
    {
    	List<String> details=new ArrayList<>();
    	details.add(exception.getLocalizedMessage());
    	int status=HttpStatus.BAD_REQUEST.value();
    	String message=exception.getMessage();
    	PolicyErrorResponse error=new PolicyErrorResponse(message, details, status);
    	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    	
    } 
    
	  
   
}
