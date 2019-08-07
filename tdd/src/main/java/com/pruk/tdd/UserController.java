package com.pruk.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/user/{id}")
	public UserResponse getUser(@PathVariable int id) {
		UserResponse userResponse = new UserResponse();
		userResponse.setEmail("pruknil@gmail.com");
		userResponse.setId(id);
		userResponse.setName("Pruk");
		return userResponse;
	}

}
