package com.pruk.tdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerUnitTest {
	@Mock
	private UserRepository userRepository;

	@Test
	public void test() {
		User pruk = new User();
		pruk.setId(1);
		pruk.setName("Pruk");
		pruk.setEmail("pruknil@gmail.com");
		given(this.userRepository.findById(1)).willReturn(Optional.of(pruk));
		UserController controller = new UserController(userRepository);
		UserResponse response = controller.getUser(1);
		
		assertEquals("Pruk", response.getName());
		assertEquals("pruknil@gmail.com", response.getEmail());
		assertEquals(1, response.getId());
	}
}
