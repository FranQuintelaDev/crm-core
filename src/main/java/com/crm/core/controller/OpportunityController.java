package com.crm.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.core.model.Opportunity;
import com.crm.core.service.OpportunityService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class OpportunityController {

    @Autowired
    private OpportunityService service;

    @PostMapping("/api/v1/opportunities")
    public Opportunity addOpportunity(@RequestBody Opportunity opportunity) {
        return service.saveOpportunity(opportunity);
    }

    @GetMapping("/api/v1/opportunities")
    public List<Opportunity> findAllOpportunities() {
        return service.getOpportunities();
    }

    @GetMapping("/api/v1/opportunities/{id}")
    public Opportunity findOpportunityById(@PathVariable int id) {
        return service.getOpportunityById(id);
    }

    @PutMapping("/api/v1/opportunities/{id}")
    public Opportunity updateOpportunity(@RequestBody Opportunity opportunity) {
        return service.updateOpportunity(opportunity);
    }

    @DeleteMapping("/api/v1/opportunities/{id}")
    public String deleteOpportunity(@PathVariable int id) {
        return service.deleteOpportunity(id);
    }
    
    @GetMapping("/api/v1/opportunities/clients")
    public List<Opportunity> findAllClients() {
        return service.getOpportunitiesAsClients();
    }
    
}