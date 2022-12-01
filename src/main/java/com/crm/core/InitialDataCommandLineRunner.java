package com.crm.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.crm.core.model.Contact;
import com.crm.core.model.Opportunity;
import com.crm.core.model.User;
import com.crm.core.repository.ContactRepository;
import com.crm.core.repository.OpportunityRepository;
import com.crm.core.repository.UserRepository;

@Component
public class InitialDataCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	OpportunityRepository opportunityRepository;
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.save( new User("Ford employee", "samplepass"));
		userRepository.save( new User("Ford boss", "samplepass"));
		userRepository.save( new User("admin", "admin"));
		Opportunity juan = opportunityRepository.save(new Opportunity( "Juan", false, null));
		Opportunity felipe = opportunityRepository.save(new Opportunity( "Felipe", false, null));
		Opportunity jesus = opportunityRepository.save(new Opportunity( "Jesus", false, null));
		Opportunity andres = opportunityRepository.save(new Opportunity( "Andres", false, null));
		Opportunity gerardo = opportunityRepository.save(new Opportunity( "Gerardo", false, null));
		Opportunity miguel = opportunityRepository.save(new Opportunity( "Miguel", true, "Ha comprado un coche"));
		Opportunity javier = opportunityRepository.save(new Opportunity( "Javier", true, "Ha comprado una moto"));
		Opportunity antonio = opportunityRepository.save(new Opportunity( "Antonio", true, "Ha comprado un coche"));

		contactRepository.save(new Contact("Mail list", "email",null, juan));
		contactRepository.save(new Contact("Mail list", "email",null, antonio));
		contactRepository.save(new Contact("Mail list", "email",null, jesus));
		contactRepository.save(new Contact("Mail list", "email",null, andres));
		contactRepository.save(new Contact("Mail list", "email",null, gerardo));
		contactRepository.save(new Contact("Mail list", "email",null, miguel));
		contactRepository.save(new Contact("Mail list", "email",null, javier));

		contactRepository.save(new Contact("Phone list", "phone",null, juan));
		contactRepository.save(new Contact("Phone list", "phone",null, antonio));
		contactRepository.save(new Contact("Phone list", "phone",null, jesus));
		contactRepository.save(new Contact("Phone list", "phone",null, andres));
		contactRepository.save(new Contact("Phone list", "phone",null, gerardo));
		contactRepository.save(new Contact("Phone list", "phone",null, miguel));
		contactRepository.save(new Contact("Phone list", "phone",null, javier));
		
	}

}
