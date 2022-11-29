package com.crm.core.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "opportunities")
public class Opportunity {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
    private String name;
	@Column(name = "isClient")
    private boolean isClient;
	@Column(name = "isClientReason")
    private String isClientReason;
	
	@Override
	public String toString() {
		return "Opportunity [id=" + id + ", name=" + name + ", isClient=" + isClient + ", isClientReason="
				+ isClientReason + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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