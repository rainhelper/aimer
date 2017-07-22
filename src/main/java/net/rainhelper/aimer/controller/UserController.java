package net.rainhelper.aimer.controller;

import lombok.extern.slf4j.Slf4j;
import net.rainhelper.aimer.entity.User;
import net.rainhelper.aimer.model.UserRequest;
import net.rainhelper.aimer.model.UserResponse;
import net.rainhelper.aimer.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public UserResponse addUser(@RequestBody UserRequest userRequest) {
		log.debug("add user request : {}", userRequest);

		User user = userService.addUser(userRequest.convertToUser());

		UserResponse userResponse = new UserResponse(user);

		log.debug("add user response : {}", userResponse);

		return userResponse;
	}

	@GetMapping("/users/{id}")
	public UserResponse getUserById(@PathVariable Long id) {
		log.debug("get user request by id : {}", id);

		User user = userService.getUserById(id);

		UserResponse userResponse = new UserResponse(user);

		log.debug("get user response : {} by id {}", userResponse, id);

		return userResponse;
	}
}
