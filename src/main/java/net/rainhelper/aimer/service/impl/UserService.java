package net.rainhelper.aimer.service.impl;

import net.rainhelper.aimer.entity.User;

public interface UserService {

	User addUser(User user);

	User getUserById(Long id);
}
