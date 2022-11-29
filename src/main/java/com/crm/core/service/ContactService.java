package com.crm.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.core.model.Contact;
import com.crm.core.repository.ContactRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;

    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> getOpportunities() {
        return repository.findAll();
    }

    public Contact getContactById(long id) {
        return repository.findById(id).get();
    }

    public String deleteContact(long id) {
        repository.deleteById(id);
        return "contact removed !! " + id;
    }

    public Contact updateContact(Contact contact) {
       return repository.save(contact);
    }

	public List<Contact> getContactsByOpportunityId(long opportunityId) {
		return repository.findByOpportunityId(opportunityId);
	}
    
  
}