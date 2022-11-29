package com.crm.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.core.model.Opportunity;
import com.crm.core.repository.OpportunityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpportunityService {
    @Autowired
    private OpportunityRepository repository;

    public Opportunity saveOpportunity(Opportunity opportunity) {
        return repository.save(opportunity);
    }

    public List<Opportunity> getOpportunities() {
        return repository.findAll();
    }

    public Opportunity getOpportunityById(long id) {
        return repository.findById(id).get();
    }

    public String deleteOpportunity(long id) {
        repository.deleteById(id);
        return "opportunity removed !! " + id;
    }

    public Opportunity updateOpportunity(Opportunity opportunity) {
       return repository.save(opportunity);
    }
    
  
}