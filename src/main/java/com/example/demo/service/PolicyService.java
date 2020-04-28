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
		List<Policy> policyList= repo.findAll();
		if(policyList.isEmpty()) {
			throw new PolicyNotFoundException("Currently there is no policy available");
		}
		return policyList;		
	}
	
	
	/**
	 * business logic to delete a specific record
	 * by using the method deleteById() of CrudRepository 
	 * 
	 * @param policy
	 * @return
	 */
	public String deletePolicy(String id) {
		String message="Policy with Id "+id+" deleted successfully";
		repo.findById(id).orElseThrow(()->new PolicyNotFoundException("The requested policy Id "+id+" does not exist in the system"));		
		repo.deleteById(id);
		return message;			
		}
	
	
 
	/**
	 * business logic to save or update a specific record 
	 * by using the method save() of CrudRepository 
	 * @param policy
	 * @return
	 */
	public Policy saveOrUpdatePolicy(Policy policy){	
		return repo.save(policy);
			
	}
	 
	/**
	 * business logic to get a specific record 
	 * by using the method findById() of CrudRepository 
	 * @param 
	 * @return
	 */
	public Policy getPolicy(String id) {
		return repo.findById(id).orElseThrow(()->new PolicyNotFoundException("The requested policy Id "+id+" does not exist in the system"));
    }

	
	
}
