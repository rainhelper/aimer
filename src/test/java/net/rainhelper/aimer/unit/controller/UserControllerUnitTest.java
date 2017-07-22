package net.rainhelper.aimer.unit.controller;

import net.rainhelper.aimer.entity.User;
import net.rainhelper.aimer.model.UserRequest;
import net.rainhelper.aimer.service.impl.UserService;
import net.rainhelper.aimer.AbstractControllerUnitTest;
import org.junit.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerUnitTest extends AbstractControllerUnitTest {

	@MockBean
	private UserService userService;

	@Test
	public void test_addUser_success() throws Exception {
		// Given
		UserRequest userRequest = new UserRequest("tester");

		given(userService.addUser(userRequest.convertToUser())).willReturn(new User(1L, userRequest.getName()));

		this.mockMvc
				// When
				.perform(post("/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(userRequest)))

				// Then
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is((1))))
				.andExpect(jsonPath("$.name", is(userRequest.getName())));
	}

	@Test
	public void test_getUserById_success() throws Exception {
		// Given
		User user = new User(1L, "tester");

		given(userService.getUserById(user.getId())).willReturn(user);

		this.mockMvc
				// When
				.perform(get("/users/{id}", user.getId())
						.contentType(MediaType.APPLICATION_JSON))

				// Then
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(user.getName())));
	}
}