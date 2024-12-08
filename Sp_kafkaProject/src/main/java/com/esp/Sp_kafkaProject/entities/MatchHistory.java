package com.esp.Sp_kafkaProject.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="History")
public class MatchHistory{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numHistory;
	private String matchName;
	private String score;
	private String event ;
	private LocalTime remainingTime;
	private LocalDateTime archivingDate;
	
	
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
	public LocalTime getRemainingTime() {
		return remainingTime;
	}
	public void setRemainingTime(LocalTime remainingTime) {
		this.remainingTime = remainingTime;
	}
	public int getNumHistory() {
		return numHistory;
	}
	
	public LocalDateTime getArchivingDate() {
		return archivingDate;
	}
	public void setArchivingDate(LocalDateTime archivingDate) {
		this.archivingDate = archivingDate;
	}
	
	public MatchHistory() {

	}
	
	
	
	

}
