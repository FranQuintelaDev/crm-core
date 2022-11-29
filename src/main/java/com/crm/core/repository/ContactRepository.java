package com.crm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.core.model.Contact;
import com.crm.core.model.Opportunity;
import com.crm.core.model.User;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	List<Contact> findByOpportunityId(Long opportunityId);

	@Transactional
	void deleteByOpportunityId(long opportunityId);


}