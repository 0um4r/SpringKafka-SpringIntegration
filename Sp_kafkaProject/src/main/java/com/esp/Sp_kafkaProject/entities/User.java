package com.esp.Sp_kafkaProject.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String matchRequest;	
	
	private String name;

	@ManyToOne
	@JoinColumn(name="Match_suivi",nullable = true)
	@JsonBackReference
	private BasketMatch theMatch;
	
	
	
	public String getMatchRequest() {
		return matchRequest;
	}

	public void setMatchRequest(String matchRequest) {
		this.matchRequest = matchRequest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public BasketMatch getTheMatch() {
		return theMatch;
	}

	public void setTheMatch(BasketMatch theMatch) {
		this.theMatch = theMatch;
	}
	
	
	public User() {
	}


	
	
	
	
	

	
}
