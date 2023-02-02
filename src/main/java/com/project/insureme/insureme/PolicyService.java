package com.project.insureme.insureme;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PolicyService {
	
	@Autowired
	PolicyRepository policyRepository;


	public Policy createPolicy() {
		Policy policy = new Policy(1,"Health","Sarthak wagh", "20-01-2023", "19-01-2024",25000);
		return policy;
	}

	public Policy viewPolicy(int policyId) {
		return policyRepository.findById(policyId).get();
	}

	public Policy createPolicy(Policy policy) {
		// TODO Auto-generated method stub
		return policyRepository.save(policy);
	}

	public Policy update(Policy policy) {
		// TODO Auto-generated method stub
		return policyRepository.save(policy);
	}

	public void deletePolicy(int policyId) {
		
		policyRepository.deleteById(policyId);
	}

	public List<Policy> getAllpolicies() {
		List<Policy> policies = new ArrayList<Policy>();
	      policyRepository.findAll().forEach(policy -> policies.add(policy));
	      return policies;
	}
	
	

	

}