package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Policy {
	
	@Id
	private long planId;
	
	@NotBlank(message = "Policy Name is mandatory")
	private String planName;
	
	@NotBlank(message = "Insurance Company is mandatory")
	private String  insuranceCompany;
	
	@NotNull(message = "Coverage Amount is mandatory")
	@Min(100000)
	private double coverageAmount;
	
	@NotNull(message = "Premium Amount is mandatory")
	@Min(300)
	private double premiumAmount;

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}	

}
