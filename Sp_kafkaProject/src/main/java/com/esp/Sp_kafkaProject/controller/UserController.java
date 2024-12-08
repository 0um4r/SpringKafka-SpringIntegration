package com.esp.Sp_kafkaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esp.Sp_kafkaProject.entities.User;
import com.esp.Sp_kafkaProject.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("user/add")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		int status = userService.save(user);
		return (status==1 ? 
				new ResponseEntity<>("Saved successfully",HttpStatus.OK) : 
					new ResponseEntity<>("Le match est achévé",HttpStatus.NOT_ACCEPTABLE));
	}
	
	@GetMapping("user/get")
	public ResponseEntity<List<User>> listUsers ()
	{ 
		List<User> users =userService.getUsers();
		
		return ( !users.isEmpty() ? new ResponseEntity<>(users,HttpStatus.OK ) : new ResponseEntity<>(HttpStatus.NO_CONTENT ));
	}
	
	@GetMapping("user/requestsMakers")
	public ResponseEntity<List<User>> listUsersByRequest(
			@RequestBody String match)
	{ 
		List<User> users = userService.getByRequest(match);
		return ( !users.isEmpty() ? new ResponseEntity<>(users,HttpStatus.OK ) : new ResponseEntity<>(HttpStatus.NO_CONTENT ));

	}


	

}
