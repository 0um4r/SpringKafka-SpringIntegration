package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProducerService;

@RestController
@RequestMapping("/api/")
public class ProducerController {

	@Autowired
	private ProducerService producerService;
	
	
	@PostMapping("si/publish")
	public void publish(@RequestBody String message)
	{ 
		//NB: C'est une notification est pas un document Message
		producerService.sendMessage(message);
	}
}
