package com.crm.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
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
	
	@Test
	void contextLoads() {
	}


	@Test
	public void saveProductOKExpectsOK() {
		Product expectedProduct = new Product(1, "product 1", 10, 10.0);
		Product actualProduct = productService.saveProduct(expectedProduct);
		assertEquals(expectedProduct.getId(),actualProduct.getId());
	}
}
