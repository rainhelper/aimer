package net.rainhelper.aimer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.rainhelper.aimer.entity.User;
import net.rainhelper.aimer.util.BeanUtils;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest implements Serializable {

	private String name;

	public User convertToUser() {
		User user = new User();

		BeanUtils.copyNotNullProperties(this, user);

		return user;
	}
}
