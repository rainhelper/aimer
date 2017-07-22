package net.rainhelper.aimer.unit.repository;

import net.rainhelper.aimer.entity.User;
import net.rainhelper.aimer.repository.UserRepository;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryUnitTest  {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test_findByName() throws Exception {
		// Given
		entityManager.persist(new User(null, "tester"));

		// When
		User user = userRepository.findByName("tester");

		// Then
		assertThat(user, notNullValue());
		assertThat(user.getName(), is("tester"));
	}
}