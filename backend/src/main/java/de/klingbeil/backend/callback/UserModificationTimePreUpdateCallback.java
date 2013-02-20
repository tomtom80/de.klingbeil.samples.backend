package de.klingbeil.backend.callback;

import java.util.Date;

import org.springframework.stereotype.Component;

import de.klingbeil.backend.entity.PreUpdateCallback;
import de.klingbeil.backend.model.User;

@Component
public class UserModificationTimePreUpdateCallback
		implements
			PreUpdateCallback<User> {

	@Override
	public Class<User> getEntityType() {
		return User.class;
	}

	@Override
	public void preUpdate(User user) {
		user.setModificationTime(new Date());
	}

}
