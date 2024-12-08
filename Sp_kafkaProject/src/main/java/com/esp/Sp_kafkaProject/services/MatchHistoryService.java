package com.esp.Sp_kafkaProject.services;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esp.Sp_kafkaProject.entities.MatchHistory;
import com.esp.Sp_kafkaProject.repositories.MatchHistoryRepository;

@Service
public class MatchHistoryService {

	@Autowired
	private MatchHistoryRepository matchHistoryRepository;

	public void historate(MatchHistory match)
	{ 
		matchHistoryRepository.save(match);
	}
	

	public void freeSpace()
	{ 
		
		Iterator<MatchHistory> navigateHistory = history().iterator();
		while (navigateHistory.hasNext())
		{ 
			MatchHistory history_match = navigateHistory.next();
			LocalTime currenTime = LocalTime.now();
			LocalTime archivingTime = history_match.getArchivingDate().toLocalTime();
		
			long enlapsedSeconds = Duration.between(archivingTime,currenTime).getSeconds();
			if (enlapsedSeconds >=60)
				matchHistoryRepository.delete(history_match);
				
		}
		
	}
	
	
	
	
	private List<MatchHistory> history()
	{ 
		return matchHistoryRepository.findAll();
	}

		
	
	
	
	
}
