package com.crm.core.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.core.model.Opportunity;
import com.crm.core.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

}