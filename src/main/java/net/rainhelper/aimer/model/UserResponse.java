package net.rainhelper.aimer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.rainhelper.aimer.entity.User;
import net.rainhelper.aimer.util.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private Long id;
	private String name;

	public UserResponse(User user) {
		BeanUtils.copyNotNullProperties(user, this);
	}
}
