package com.project.insureme.insureme;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;



@SpringBootTest
class InsureMeApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testcreatePolicy() {
		Policy policy = new Policy(1,"Health","Sarthak wagh", "20-01-2023", "19-01-2024",25000);
		PolicyService pService=new PolicyService();
		assertEquals(policy.getPolicyId(),pService.createPolicy().getPolicyId());
	}
	
	@Autowired
	PolicyService policyService;
	
	@MockBean
	PolicyRepository policyRepository;
	
	@Test
	void testViewPolicy() {
		List<Policy> policy = policyRepository.findAll();
		assertThat(policy.size()).isEqualTo(0);
	}
   
    
   

}