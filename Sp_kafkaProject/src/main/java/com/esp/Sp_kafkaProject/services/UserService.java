package com.esp.Sp_kafkaProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esp.Sp_kafkaProject.entities.BasketMatch;
import com.esp.Sp_kafkaProject.entities.User;
import com.esp.Sp_kafkaProject.repositories.MatchRepository;
import com.esp.Sp_kafkaProject.repositories.UserRepository;
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MatchRepository matchRepository;
			
	public int save (User user)
	{ 
		String request = user.getMatchRequest();
		BasketMatch bM = matchRepository.findByMatchName(request);
		if (bM.getRemainingTime().toSecondOfDay() > 30)
		{ 
			user.setTheMatch(bM);
			userRepository.save(user);
			return 1;
		}
		return 0;

		
	}
	
	public void deleteUser(int id)
	{ 
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) 
			userRepository.delete(user.get());
		
	}
	
	public List<User> getUsers()
	{ 
		List<User> users = userRepository.findAll();
		return users;
	
	}
	
	public List<User> getByRequest(String match)
	{ 
		List<User> users = userRepository.findByMatchRequest(match);
		return users;
		
	}
	
	

	


}
	
	

