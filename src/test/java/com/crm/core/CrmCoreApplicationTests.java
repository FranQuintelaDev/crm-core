package com.crm.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.assertj.core.api.AssertDelegateTarget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crm.core.model.Contact;
import com.crm.core.model.Opportunity;
import com.crm.core.model.User;
import com.crm.core.service.ContactService;
import com.crm.core.service.OpportunityService;
import com.crm.core.service.UserService;

@SpringBootTest
class CrmCoreApplicationTests {


	@Autowired
	private UserService userService;
	@Autowired
	private OpportunityService opportunityService;
	@Autowired
	private ContactService contactService;

	@BeforeEach
	void setUp() {
	}

	@Disabled("Sample test")
	@Test
	void contextLoads() {
	}

	@Test
	public void signUpOKExpectOK() {
		User expectedUser = new User("Ford boss", "samplepass");
		User actualUser = userService.signUp(expectedUser);
		assertEquals(expectedUser.getUsername(), actualUser.getUsername());
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
		userService.saveUser(expectedUser);
		
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
		Opportunity expectedOpportunity = new Opportunity(1, "Juan", false, null);
		opportunityService.saveOpportunity(expectedOpportunity);
		
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
		opportunityService.saveOpportunity(expectedOpportunity);
		
		Opportunity actualOpportunity = opportunityService.getOpportunityById(1);
		assertEquals(expectedOpportunity.getId(), actualOpportunity.getId());
	}
	
	@Test
	public void getOpportunityWithContactsExpectOK() {
		Opportunity existingOpportunity = new Opportunity(1, "Juan", false, null);
		opportunityService.saveOpportunity(existingOpportunity);
		
		Contact existingContact = new Contact("Mail list", "email",null, existingOpportunity);
		contactService.saveContact(existingContact);
		
		//TODO CAMBIAR CUANDO SE HAGA UN GET OPPORTUNITY EAGER
		List<Contact> contacts = contactService.getContactsByOpportunityId(existingOpportunity.getId());
		boolean containsContact = contacts.stream().anyMatch(x -> x.getTitle().equals(existingContact.getTitle()));
		assertEquals(true, containsContact);
		
	}
	
	@Disabled("To be implemented")
	@Test
	public void getOpportunityWithNonExistingOpExpectKO() {
	}
	
	@Test
	public void markAsClientExpectOK() {
		Opportunity existingOpportunity = opportunityService.saveOpportunity(new Opportunity(1, "Juan", false, null));
		
		existingOpportunity.setClient(true);
		existingOpportunity.setIsClientReason("Ha comprado un coche");
		Opportunity expectedOpportunity = opportunityService.updateOpportunity(existingOpportunity);
		
		assertEquals(expectedOpportunity.getId(), existingOpportunity.getId());

	}
	
	@Disabled("To be implemented")
	@Test
	public void markAsClientWithInvalidDataExpectKO() {
	}
	
	@Test
	public void getClientsThenFindExistingClExpectOK() {
		Opportunity existingOpportunity = opportunityService.saveOpportunity(new Opportunity(1, "Antonio", true, "Ha comprado un coche"));
		
		List<Opportunity> opportunitiesAsClients = opportunityService.getOpportunitiesAsClients();
		boolean containsOpportunityAsClient = opportunitiesAsClients.stream().anyMatch(x -> x.getName().equals(existingOpportunity.getName()));
		assertEquals(true, containsOpportunityAsClient);
		
	}
	
	@Disabled("To be implemented")
	@Test
	public void getClientsThenCantFindExistingNonClientExpectOK() {
	}
	
	@Test
	public void saveContactExpectOK() {
		Opportunity existingOpportunity = new Opportunity(1, "Juan", false, null);
		opportunityService.saveOpportunity(existingOpportunity);
		
		Date date = new GregorianCalendar(2023,11,31).getTime();
		Contact expectedContact = contactService.saveContact(new Contact("Descuento 20%", "phone",date, existingOpportunity));
		
		assertEquals(expectedContact.getTitle(), "Descuento 20%");
	}

	@Disabled("To be implemented")
	@Test
	public void saveContactWithInvalidDataExpectKO() {
	}
	

}
