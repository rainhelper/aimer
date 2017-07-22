package net.rainhelper.aimer.integration;

import net.rainhelper.aimer.AbstractIntegrationTest;
import net.rainhelper.aimer.model.UserRequest;
import net.rainhelper.aimer.model.UserResponse;
import org.junit.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

public class UserControllerIntegrationTest extends AbstractIntegrationTest {

	@Test
	public void test_addUser_success() throws Exception {
		// Given
		UserRequest userRequest = new UserRequest("tester");

		// When
		ResponseEntity<UserResponse> responseEntity =
				restTemplate.postForEntity("/users", userRequest, UserResponse.class);
		UserResponse userResponse = responseEntity.getBody();

		// Then
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(userRequest.getName(), userResponse.getName());
	}

	@Test
	public void test_getUserById_success() throws Exception {
		// Given
		UserRequest userRequest = new UserRequest("tester");
		ResponseEntity<UserResponse> responseEntity =
				restTemplate.postForEntity("/users", userRequest, UserResponse.class);
		UserResponse userResponse = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(userResponse.getName());

		// When
		responseEntity =
				restTemplate.getForEntity("/users/" + userResponse.getId(), UserResponse.class);
		UserResponse getUserResponse = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(userResponse.getName(), getUserResponse.getName());
		assertEquals(userResponse.getId(), getUserResponse.getId());
	}
}