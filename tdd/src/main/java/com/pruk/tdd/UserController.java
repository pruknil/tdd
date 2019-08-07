package com.pruk.tdd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private UserRepository userRepository;
	

	@Autowired
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@GetMapping("/user/{id}")
	public UserResponse getUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			UserResponse userResponse = new UserResponse();
			userResponse.setEmail(user.get().getEmail());
			userResponse.setId(user.get().getId());
			userResponse.setName(user.get().getName());
			return userResponse;
		}
		return new UserResponse();
	}

}
