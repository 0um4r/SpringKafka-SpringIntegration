package com.esp.Sp_kafkaProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esp.Sp_kafkaProject.entities.BasketMatch;
import com.esp.Sp_kafkaProject.kafka.Producer;

@RestController
@RequestMapping("/api/kafka/")
public class MessageController {
	
	@Autowired
	private Producer producer;
	
	@PostMapping("publish")
	public ResponseEntity<String> sendMessage(@RequestBody BasketMatch match)
	{
		producer.sendMessage(match);
		return new ResponseEntity<>("Message sent successfully!",HttpStatus.OK);
	}

}
