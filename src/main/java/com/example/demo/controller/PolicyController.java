package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Policy;
import com.example.demo.service.PolicyService;

@RestController
@RequestMapping("policy")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PolicyController {
	
	@Autowired
	PolicyService policyService;
	
	/**
	 * creating a get mapping that retrieves all the policy  detail from database 
	 * @param policyId
	 * @return
	 */
	@CrossOrigin(origins = "http://example.com")
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
	 * @throws MethodArgumentNotValidException 
	 */
	@PostMapping("/plan/add")
	public Policy savePolicy(@Valid @RequestBody Policy policy) {
			return policyService.saveOrUpdatePolicy(policy);	
		
	}
	
	
	/**
	 * creating put mapping to update or save the data in database
	 * @param 
	 * @return
	 * @throws MethodArgumentNotValidException 
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
	
	

}
