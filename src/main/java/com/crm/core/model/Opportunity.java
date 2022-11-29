package com.crm.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Opportunity {
   
	private int id;
    private String name;
    private boolean isClient;
    private String isClientReason;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isClient() {
		return isClient;
	}
	public void setClient(boolean isClient) {
		this.isClient = isClient;
	}
	public String getIsClientReason() {
		return isClientReason;
	}
	public void setIsClientReason(String isClientReason) {
		this.isClientReason = isClientReason;
	}
	
	public Opportunity(int id, String name, boolean isClient, String isClientReason) {
		super();
		this.id = id;
		this.name = name;
		this.isClient = isClient;
		this.isClientReason = isClientReason;
	}
	public Opportunity() {
		super();
	}
    
	
    
	
}