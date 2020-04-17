package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Policy;
import com.example.demo.exception.PolicyNotFoundException;
import com.example.demo.repo.PolicyRepository;


@Service
public class PolicyService {
	
	@Autowired
	PolicyRepository repo;

	
	/**
	 * business logic to get all the policy record
	 * by using the method findaAll() of CrudRepository
	 * @param 
	 * @return
	 */
	public List<Policy> getAllPolicy(){			
		return repo.findAll();	
	}
	
	
	/**
	 * business logic to delete a specific record
	 * by using the method deleteById() of CrudRepository 
	 * 
	 * @param policy
	 * @return
	 */
	public String deletePolicy(long id) {
		String message="Policy with Id "+id+" deleted successfully";
		repo.findById(id).orElseThrow(()->new PolicyNotFoundException("Policy Id "+id+" does not exist"));		
		repo.deleteById(id);
		return message;
			
		}
	
	
 
	/**
	 * business logic to save or update a specific record 
	 * by using the method save() of CrudRepository 
	 * @param policy
	 * @return
	 */
	public Policy saveOrUpdatePolicy(Policy policy) {	
		return repo.save(policy);
		
	}
	 
	/**
	 * business logic to get a specific record 
	 * by using the method findById() of CrudRepository 
	 * @param 
	 * @return
	 */
	public Policy getPolicy(long id) throws PolicyNotFoundException {
		return repo.findById(id).orElseThrow(()->new PolicyNotFoundException("Policy Id "+id+" does not exist"));
	
    }

	
	
}
