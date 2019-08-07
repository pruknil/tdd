package com.pruk.tdd;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerMVCTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void test() throws Exception {
		UserResponse userResponse = new UserResponse();
		userResponse.setEmail("pruknil@gmail.com");
		userResponse.setId(1);
		userResponse.setName("Pruk");

		MvcResult result = this.mvc.perform(get("/user/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		String resultJson = result.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		UserResponse response = mapper.readValue(resultJson, UserResponse.class);
		assertEquals(userResponse, response);

	}

}
