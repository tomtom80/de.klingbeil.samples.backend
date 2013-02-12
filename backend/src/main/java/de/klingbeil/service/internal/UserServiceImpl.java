package de.klingbeil.service.internal;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import de.klingbeil.model.User;
import de.klingbeil.repository.UserRepository;
import de.klingbeil.service.UserService;

public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserServiceImpl.class);
	@Resource
	UserRepository userRepository;

	@Override
	public User create(User user) {
		Assert.notNull(user, "user must not be null");

		LOGGER.debug("Creating a new user: " + user);
		return userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		Assert.notNull(id, "id must not be null");

		User userToDelete = findById(id);
		LOGGER.debug("Deleteing a user: " + userToDelete);
		userRepository.delete(userToDelete);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Long id) {
		Assert.notNull(id, "id must not be null");

		return userRepository.findOne(id);
	}

	@Override
	public User update(User updatedUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
