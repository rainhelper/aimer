package net.rainhelper.aimer.repository;

import net.rainhelper.aimer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
}
