package com.esp.Sp_kafkaProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esp.Sp_kafkaProject.entities.BasketMatch;
import com.esp.Sp_kafkaProject.repositories.MatchRepository;

@Service
public class MatchService {

	@Autowired
	private MatchRepository matchRepository;
	
	public void save(BasketMatch match)
	{ 
		matchRepository.save(match);
	}
	
	public List<BasketMatch> matchs()
	{ 
		return matchRepository.findAll();
	}
	
	public BasketMatch getMatch(String matchName)
	{ 
		BasketMatch match = matchRepository.findByMatchName(matchName);
		return match;
	}	
	
	public BasketMatch getMatch(int id)
	{ 
		Optional<BasketMatch> match = matchRepository.findById(id);
		return match.get();
	}
	
	
	public BasketMatch updateMatch(int id,BasketMatch newVersion)
	{ 
		
		BasketMatch match = matchRepository.findById(id).orElseThrow();
		if(match.getMatchName().equals(newVersion.getMatchName()))
		{
		match.setEvent(match.getEvent()!=newVersion.getEvent()
				? newVersion.getEvent() : match.getEvent());
		
		match.setScore(match.getScore()!=newVersion.getScore()
				? newVersion.getScore() : match.getScore());
		
		match.setRemainingTime(newVersion.getRemainingTime()!=match.getRemainingTime()
				? newVersion.getRemainingTime() : match.getRemainingTime());
		
		
		matchRepository.save(match);
		return match;
		}
		return null;
		
		
	}
	

}
