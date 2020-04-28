package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Policy;

//repository that extends JPARepository 
@Repository
public interface PolicyRepository  extends JpaRepository<Policy,String>{

}
