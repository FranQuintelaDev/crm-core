package com.crm.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.core.model.Contact;
import com.crm.core.model.Opportunity;
import com.crm.core.service.ContactService;
import com.crm.core.service.OpportunityService;
import com.crm.core.service.ContactService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping
public class ContactController {

	@Autowired
	private ContactService service;

	@Autowired
	private OpportunityService opportunityService;

	@PostMapping("/api/v1/opportunities/{opportunityId}/contacts")
	public Contact addContact(@PathVariable long opportunityId, @RequestBody Contact contact) {
		
		Opportunity opportunity = opportunityService.getOpportunityById(opportunityId);
		contact.setOpportunity(opportunity);		
			
		return service.saveContact(contact);
		
	}

	@GetMapping("/api/v1/opportunities/{opportunityId}/contacts")
	public List<Contact> findAllContacts(@PathVariable long opportunityId) {
		return service.getContactsByOpportunityId(opportunityId);
	}

	@GetMapping("/api/v1/opportunities/{opportunityId}/contacts/{contactID}")
	public Contact findContactById(@PathVariable long opportunityId, @PathVariable long contactID) {
		return service.getContactById(contactID);
	}

	@PutMapping("/api/v1/opportunities/{contactID}/contacts")
	public Contact updateContact(@RequestBody Contact contact) {
		return service.updateContact(contact);
	}

	@DeleteMapping("/api/opportunities/{contactID}/contacts")
	public String deleteContact(@PathVariable long contactID) {
		return service.deleteContact(contactID);
	}

}