package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Policy;
import com.example.demo.service.PolicyService;

@RestController
@RequestMapping("policy")
public class PolicyController {
	
	@Autowired
	PolicyService policyService;
	
	/**
	 * creating a get mapping that retrieves all the policy  detail from database 
	 * @param policyId
	 * @return
	 */
	@GetMapping("/plan/getAll")
	public List<Policy> getAllPolicy(){
		return policyService.getAllPolicy();
	}
	
	/**
	 * creating  delete mapping that deletes a specified policy
	 * @param 
	 * @return
	 */
	@DeleteMapping("/plan/{planId}")
	public String deletePolicy(@PathVariable("planId") long planId){
		return policyService.deletePolicy(planId);	
	}
	
	/**
	 * creating post mapping that post the policy details in the database
	 * @param 
	 * @return
	 */
	@PostMapping("/plan/add")
	public Policy savePolicy(@Valid @RequestBody Policy policy) {
		return policyService.saveOrUpdatePolicy(policy);	
	}
	
	
	/**
	 * creating put mapping to update or save the data in database
	 * @param 
	 * @return
	 */
	@PutMapping("/plan/update")
	public Policy updatePolicy(@Valid @RequestBody Policy policy) {
		return policyService.saveOrUpdatePolicy(policy);
		
	}
	/**
	 * creating a get mapping that retrieves the detail of a specific policy  
	 * @param 
	 * @return
	 */
	@GetMapping("/plan/{planId}")
	public Policy getPolicy(@PathVariable long planId) {	
		return policyService.getPolicy(planId);
			
		}
	
	/**
	 * Exception handling for incorrect field input 
	 * @param 
	 * @return
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	

}
