package com.crm.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.assertj.core.api.AssertDelegateTarget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crm.core.model.Opportunity;
import com.crm.core.model.User;
import com.crm.core.service.OpportunityService;
import com.crm.core.service.UserService;

@SpringBootTest
class CrmCoreApplicationTests {


	@Autowired
	private UserService userService;
	@Autowired
	private OpportunityService opportunityService;

	@BeforeEach
	void setUp() {
	}

	@Disabled("Sample test")
	@Test
	void contextLoads() {
	}

	@Test
	public void signUpOKExpectOK() {
		User expectedUser = new User(4, "Ford boss", "samplepass");
		User actualUser = userService.signUp(expectedUser);
		assertEquals(expectedUser.getId(), actualUser.getId());
	}
	
	@Disabled("To be implemented")
	@Test
	public void signUpExistingUserExpectKO() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void signUpInvalidDataExpectKO() {
	}
	
	@Test
	public void loginOKExpectOK() {
		User expectedUser = new User(1, "Ford employee", "samplepass");
		User actualUser = userService.logIn(expectedUser);
		assertEquals(expectedUser.getId(), actualUser.getId());
	}
	
	@Disabled("To be implemented")
	@Test
	public void loginWrongPassExpectKO() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void loginNonExistingUserExpectKO() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void loginInvalidDataExpectKO() {
	}
	
	@Test
	public void getOpportunitiesThenFindExistingOpExpectOK() {
		List<Opportunity> opportunities = opportunityService.getOpportunities();
		boolean containsOpportunity = opportunities.stream().anyMatch(x -> x.getName().equals("Juan"));
		assertEquals(true, containsOpportunity);
	}
	
	@Disabled("To be implemented")
	@Test
	public void getOpportunitiesAsFailUserExpectKO() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void getOpportunitiesThenCantFindExistingClientExpectOK() {
	}
	
	@Test
	public void getOpportunityExpectOK() {
		Opportunity expectedOpportunity = new Opportunity(1, "Juan", false, null);
		Opportunity actualOpportunity = opportunityService.getOpportunityById(1);
		assertEquals(expectedOpportunity.getId(), actualOpportunity.getId());
	}
	
	@Disabled("To be implemented")
	@Test
	public void getOpportunityWithContactsExpectOK() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void getOpportunityWithNonExistingOpExpectKO() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void markAsClientOKExpectOK() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void markAsClientWithInvalidDataExpectKO() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void getClientsThenFindExistingClExpectOK() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void getClientsThenCantFindExistingNonClientExpectOK() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void saveContactExpectOK() {
	}

	@Disabled("To be implemented")
	@Test
	public void saveContactWithInvalidDataExpectKO() {
	}
	

}
