package com.pruk.tdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pruk.tdd.model.UserResponse;

@RestController
public class UserController {
	
	@GetMapping("/user/{id}")
	public UserResponse getUser(@PathVariable int id) {
		UserResponse userResponse = new UserResponse();
		userResponse.setEmail("pruknil@gmail.com");
		userResponse.setId(id);
		userResponse.setName("Pruk");
		return userResponse;
	}

}
