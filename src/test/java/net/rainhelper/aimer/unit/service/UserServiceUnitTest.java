package net.rainhelper.aimer.unit.service;

import net.rainhelper.aimer.entity.User;
import net.rainhelper.aimer.repository.UserRepository;
import net.rainhelper.aimer.service.UserServiceImpl;
import net.rainhelper.aimer.service.impl.UserService;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class UserServiceUnitTest  {

	@TestConfiguration
	static class UserServiceImplTestContextConfiguration {
		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}
	}

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void test_addUser_success() throws Exception {
		// Given
		User user = new User(null, "name");
		given(userRepository.save(user)).willReturn(addUser(1L, "name"));

		// When
		user = userService.addUser(user);

		// Then
		Assert.assertNotNull(user.getId());
	}

	@Test
	public void test_getUserById_success() throws Exception {
		// Given
		given(userRepository.findOne(1L)).willReturn(new User(1L, "name"));

		// When
		User getUser = userService.getUserById(1L);

		// Then
		Assert.assertEquals(getUser.getName(), "name");
	}

	public User addUser(Long id, String name) {
		return new User(id, name);
	}
}