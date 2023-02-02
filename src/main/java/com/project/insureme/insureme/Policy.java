package com.project.insureme.insureme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table
public class Policy {
	
	@Id 
	@Column
	private int policyId;
	@Column
	private String policyType;
	@Column
	private String policyHolderName;
	@Column
	private String policyStartDate;
	@Column
	private String policyEndDate;
	@Column
	private double policyPrice;
	

	public Policy(int policyId, String policyType, String policyHolderName, String policyStartDate,
			String policyEndDate, double policyPrice) {
		super();
		this.policyId = policyId;
		this.policyType = policyType;
		this.policyHolderName = policyHolderName;
		this.policyStartDate = policyStartDate;
		this.policyEndDate = policyEndDate;
		this.policyPrice = policyPrice;
	}

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public String getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(String policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public String getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(String policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public double getPolicyPrice() {
		return policyPrice;
	}

	public void setPolicyPrice(double policyPrice) {
		this.policyPrice = policyPrice;
	}

}