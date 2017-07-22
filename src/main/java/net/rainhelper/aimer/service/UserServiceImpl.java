package net.rainhelper.aimer.service;

import lombok.extern.slf4j.Slf4j;
import net.rainhelper.aimer.entity.User;
import net.rainhelper.aimer.repository.UserRepository;
import net.rainhelper.aimer.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		log.debug("add user request : {}", user);

		user = userRepository.save(user);

		log.debug("add user response : {}", user);

		return user;
	}

	@Override
	public User getUserById(Long id) {
		log.debug("get user request for id [{}]", id);

		User user = userRepository.findOne(id);

		log.debug("get user response for id [{}] : {}", id, user);

		return user;
	}
}