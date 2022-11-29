package com.crm.core.repository;


import org.springframework.stereotype.Repository;

import com.crm.core.model.Opportunity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OpportunityRepository {
    

    public List<Opportunity> createOpportunities() {
        return List.of(
                new Opportunity(1, "Juan", false, null),
                new Opportunity(2, "Antonio", true, "Ha comprado una moto"),
                new Opportunity(3, "Feli", false, null)
        );
    }
    
    private List<Opportunity> list = new ArrayList<Opportunity>(createOpportunities());

    public List<Opportunity> getAllOpportunities() {
        return list;
    }

    public Opportunity findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Opportunity> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public Opportunity save(Opportunity u) {
        Opportunity opportunity = new Opportunity();
        opportunity.setId(u.getId());
        opportunity.setName(u.getName());
        opportunity.setClient(u.isClient());
        opportunity.setIsClientReason(u.getIsClientReason());
        list.add(opportunity);
        return opportunity;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Opportunity update(Opportunity u) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (u.getId())) {
                id = u.getId();
                idx = i;
                break;
            }
        }

        Opportunity opportunity = new Opportunity();
        opportunity.setId(id);
        opportunity.setName(u.getName());
        opportunity.setClient(u.isClient());
        opportunity.setIsClientReason(u.getIsClientReason());
        list.set(idx, u);
        return opportunity;
    }
}