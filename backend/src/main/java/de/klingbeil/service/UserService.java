package de.klingbeil.service;

import java.util.List;

import de.klingbeil.model.User;

/**
 * Declares methods used to obtain and modify user information.
 */
public interface UserService {

	/**
	 * Creates a new user.
	 * 
	 * @param user
	 *            The information of the created person.
	 * @return The created user.
	 */
	public User create(User user);

	/**
	 * Deletes a user.
	 * 
	 * @param userId
	 *            The id of the user to delete.
	 * @throws IllegalArgumentException
	 *             if user with userId not found
	 */
	public void delete(Long userId);

	/**
	 * Finds all users.
	 * 
	 * @return A list of users.
	 */
	public List<User> findAll();

	/**
	 * Finds user by id.
	 * 
	 * @param id
	 *            The id of the user to find.
	 * @return The user. If no user is found, this method returns null.
	 * @throws IllegalArgumentException
	 *             if user with id not found
	 */
	public User findById(Long id);

	/**
	 * Updates the information of a user.
	 * 
	 * @param updatedUser
	 *            The information of the updated user.
	 * @return The updated user.
	 */
	public User update(User updatedUser);
}
