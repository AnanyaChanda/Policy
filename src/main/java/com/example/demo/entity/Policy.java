package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PolicyDetails")
public class Policy implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Plan_Id")
	private String planId;
	
	@NotBlank(message = "Policy Name is mandatory")
	@Column(name="Plan_Name")
	private String planName;
	
	@NotBlank(message = "Insurance Company is mandatory")
	@Column(name="Insurance_Company_Name")
	private String  insuranceCompany;
	
	@NotNull(message = "Coverage Amount is mandatory")
	@Min(100000)
	@Column(name="Coverage_Amount")
	private double coverageAmount;
	
	@NotNull(message = "Premium Amount is mandatory")
	@Min(300)
	@Column(name="Premium_Amount")
	private double premiumAmount;
	
	
	@NotNull(message = "PreOrPostHospitalization is mandatory")
	@Column(name="Pre_Post_Hospitalization")
	private String preOrPostHospitalization;
	
	@NotNull(message = "PreExistingDiseases  is mandatory")
	@Column(name="pre_ExistingDiseases")
	private String preExistingDiseases;
	
	@NotNull(message = "bonusPercentage  is mandatory")
	@Min(10)
	@Column(name = "No_Claim_Bonus_Percentage")
	private double bonusPercentage;
	
	
	@Column(name="Co_Payment",nullable=false) 
	private String copayment="Applicable";

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
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

	public String getPreOrPostHospitalization() {
		return preOrPostHospitalization;
	}

	public void setPreOrPostHospitalization(String preOrPostHospitalization) {
		this.preOrPostHospitalization = preOrPostHospitalization;
	}

	public String getPreExistingDiseases() {
		return preExistingDiseases;
	}

	public void setPreExistingDiseases(String preExistingDiseases) {
		this.preExistingDiseases = preExistingDiseases;
	}

	public double getBonusPercentage() {
		return bonusPercentage;
	}

	public void setBonusPercentage(double bonusPercentage) {
		this.bonusPercentage = bonusPercentage;
	}

	public String getCopayment() {
		return copayment;
	}

	public void setCopayment(String copayment) {
		this.copayment = copayment;
	}
	
	
	
	


}
