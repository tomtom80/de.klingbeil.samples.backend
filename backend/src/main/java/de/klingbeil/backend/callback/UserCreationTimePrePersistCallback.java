package de.klingbeil.backend.callback;

import java.util.Date;

import org.springframework.stereotype.Component;

import de.klingbeil.backend.entity.PrePersistCallback;
import de.klingbeil.backend.model.User;

@Component
public class UserCreationTimePrePersistCallback
		implements
			PrePersistCallback<User> {

	@Override
	public Class<User> getEntityType() {
		return User.class;
	}

	@Override
	public void prePersist(User entity) {
		entity.setCreationTime(new Date());
	}

}
