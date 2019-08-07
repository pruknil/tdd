package com.pruk.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void found_get_data_by_id_1() {
		User entity = new User();
		entity.setEmail("pruknil@gmail.com");
		entity.setId(1);
		entity.setName("Pruk");
		userRepository.save(entity);
		Optional<User> found = userRepository.findById(1);
		assertTrue(found.isPresent());
		assertEquals(entity,found.get());
	}
}
