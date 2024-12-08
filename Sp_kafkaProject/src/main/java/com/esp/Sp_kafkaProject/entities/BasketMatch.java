package com.esp.Sp_kafkaProject.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class BasketMatch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String matchName;
	private String score;
	private String event ;
	private LocalTime remainingTime = LocalTime.of(0, 45,0);
	
	@OneToMany(mappedBy = "theMatch")
	@JsonManagedReference
	private List<User> users = new ArrayList<>();
	
	

	public String getMatchName() {
		return matchName;
	}
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public int getId() {
		return id;
	}

	public LocalTime getRemainingTime() {
		return remainingTime;
	}
	public void setRemainingTime(LocalTime remainingTime) {
		this.remainingTime = remainingTime;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	public BasketMatch() {
		
	}
	
	
	
	
}
