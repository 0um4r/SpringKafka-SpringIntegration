package com.esp.Sp_kafkaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esp.Sp_kafkaProject.entities.BasketMatch;
import com.esp.Sp_kafkaProject.services.MatchService;


@RestController
@RequestMapping("/api/")
public class MatchController {

	@Autowired
	private MatchService matchService;
	
	
	@PostMapping("matchs/add")
	public ResponseEntity<String> saveMatch(@RequestBody BasketMatch match) 
	{ 
		matchService.save(match);
		return new ResponseEntity<>("Saved successfully!",HttpStatus.OK);
				
	}
	
	@GetMapping("matchs")
	public ResponseEntity<List<BasketMatch>> matchs()
	{ 
		List<BasketMatch> matchs = matchService.matchs();
		if (matchs.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(matchs,HttpStatus.OK);
	}
	
	
	@GetMapping("matchs/get/{matchName}")
	public ResponseEntity<BasketMatch> getMatch(@PathVariable String matchName)
	{ 
		BasketMatch match = matchService.getMatch(matchName);
		if(match!=null)
			return new ResponseEntity<>(match,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("matchs/get/{id}")
	public ResponseEntity<BasketMatch> getMatch(@PathVariable int id)
	{ 
		BasketMatch match = matchService.getMatch(id);
		if(match!=null)
			return new ResponseEntity<>(match,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
//	@PutMapping("matchs/update")
//	
//	public ResponseEntity<BasketMatch> updateMatch(@RequestBody BasketMatch newVersion)
//	{ 
//		BasketMatch match = matchService.updateMatch(newVersion);
//		if(match!=null)
//			return new ResponseEntity<>(match,HttpStatus.OK);
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
//	
//	
	@PutMapping("matchs/update/{id}")
	public ResponseEntity<BasketMatch> updateMatch(@PathVariable int id, @RequestBody BasketMatch newVersion)
	{ 
		BasketMatch match = matchService.updateMatch(id,newVersion);
		if(match!=null)
			return new ResponseEntity<>(match,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
