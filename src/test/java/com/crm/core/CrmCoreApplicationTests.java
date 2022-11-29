package com.crm.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crm.core.model.Product;
import com.crm.core.repository.ProductRepository;
import com.crm.core.service.ProductService;

@SpringBootTest
class CrmCoreApplicationTests {

	@Autowired
	private ProductService productService;

	@BeforeEach
	void setUp() {
	}

	@Disabled("Sample test")
	@Test
	void contextLoads() {
	}

	@Disabled("Sample test")
	@Test
	public void saveProductOKExpectsOK() {
		Product expectedProduct = new Product(1, "product 1", 10, 10.0);
		Product actualProduct = productService.saveProduct(expectedProduct);
		assertEquals(expectedProduct.getId(), actualProduct.getId());
	}

	@Disabled("To be implemented")
	@Test
	public void signUpOKExpectOK() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void signUpExistingUserExpectKO() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void signUpInvalidDataExpectKO() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void loginOKExpectOK() {
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
	
	@Disabled("To be implemented")
	@Test
	public void getOpportunitiesThenFindExistingOpExpectOK() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void getOpportunitiesAsFailUserExpectKO() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void getOpportunitiesThenCantFindExistingClientExpectOK() {
	}
	
	@Disabled("To be implemented")
	@Test
	public void getOpportunityExpectOK() {
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
