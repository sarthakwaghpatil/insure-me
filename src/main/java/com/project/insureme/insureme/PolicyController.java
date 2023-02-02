package com.project.insureme.insureme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PolicyController {
	
	@Autowired
	PolicyService policyService;
	
	@GetMapping("/createPolicy")
	public Policy createPolicy() {
		return policyService.createPolicy();
	}
	
	@PostMapping("/createPolicy")
	public Policy createPolicy(@RequestBody Policy policy) {
		return policyService.createPolicy(policy);
	}
	
	@PutMapping("/updatePolicy/{policyId}")
	public Policy updatePolicy(@RequestBody Policy policy ) {
		return policyService.update(policy);
	}
	
	@GetMapping("/viewPolicy/{policyId}")
	public Policy viewPolicy(@PathVariable("policyId")int policyId) {
		return policyService.viewPolicy(policyId);
	}
	
	@DeleteMapping("/deletePolicy/{policyId}")
	public void deletePolicy(@PathVariable("policyId")int policyId) {
		policyService.deletePolicy(policyId);
	}
	@GetMapping("/viewAll")
	public List<Policy> getAllpolicies() {
		return policyService.getAllpolicies();
	}
	
	
	
	
	
}