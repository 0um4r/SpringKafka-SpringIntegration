package com.esp.Sp_kafkaProject.kafka;


import java.time.LocalDateTime;
import java.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.esp.Sp_kafkaProject.entities.BasketMatch;
import com.esp.Sp_kafkaProject.entities.MatchHistory;
import com.esp.Sp_kafkaProject.repositories.MatchRepository;
import com.esp.Sp_kafkaProject.services.MatchHistoryService;

@Service
public class Consumer {

	private static final Logger LOGGER =LoggerFactory.getLogger(Consumer.class); 
	
	@Autowired
	private MatchRepository matchRepository;
	
	@Autowired
	private MatchHistoryService matchHistoryService;
	
	@KafkaListener(topics="Basket_info",groupId = "fansDuBasket_web")
	public void receiveMessage(BasketMatch match)
	{ 
	  	
		
		matchHistoryService.freeSpace();
		MatchHistory history = new MatchHistory();
		history.setArchivingDate(LocalDateTime.now());
		history.setEvent(match.getEvent());
		history.setMatchName(match.getMatchName());
		history.setRemainingTime(match.getRemainingTime());
		history.setScore(match.getScore());
					
		String MATCH  = match.getMatchName();
		
		BasketMatch targetMatch = matchRepository.findByMatchName(MATCH);
      
		targetMatch.setEvent(targetMatch.getEvent()!=match.getEvent()
				? match.getEvent() : targetMatch.getEvent());
		
		targetMatch.setScore(targetMatch.getScore()!=match.getScore()
				? match.getScore() : targetMatch.getScore());
		
		targetMatch.setRemainingTime(match.getRemainingTime()!=targetMatch.getRemainingTime()
				? match.getRemainingTime() : targetMatch.getRemainingTime());
		
		if (targetMatch.getRemainingTime().toSecondOfDay()>=10)
		{
				matchRepository.save(targetMatch);
				matchHistoryService.historate(history);

		}
		else
			return;
		
		
		String SCORE = targetMatch.getScore();
		LocalTime TIME = targetMatch.getRemainingTime();
        String SYNOPSIS = MATCH + "--" + SCORE + "--Remaining time is: "+TIME + "captured at : " +LocalTime.now();
        LOGGER.info(SYNOPSIS);
	}
	
	
	
}
