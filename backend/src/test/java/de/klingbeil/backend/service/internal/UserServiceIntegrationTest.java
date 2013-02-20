package de.klingbeil.backend.service.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import de.klingbeil.backend.model.User;
import de.klingbeil.backend.service.UserService;
import de.klingbeil.config.context.ApplicationContextBackend;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextBackend.class})
@Transactional
public class UserServiceIntegrationTest {

	@Resource
	private UserService userService;
	@PersistenceContext
	private EntityManager entityManager;

	@Before
	public void setUp() {
	}

	@Test
	public void testCreate() {
		String email = "foo@bar.com";
		String firstName = "Fred";
		String lastName = "Feuerstein";
		User user = createValidUser(email, firstName, lastName);

		userService.create(user);

		assertEquals(email, user.getEmail());
		assertNotNull(user.getCreationTime().getTime());
	}

	@Test
	public void testUpdate() throws Exception {
		String email = "foo@bar.com";
		String firstName = "Fred";
		String newFirstName = "Wilma";
		String lastName = "Feuerstein";
		User user = createValidUser(email, firstName, lastName);
		User createdUser = userService.create(user);
		createdUser.setFirstName(newFirstName);

		userService.update(createdUser);
		entityManager.flush();

		User updatedUser = userService.findById(createdUser.getId());
		assertNotNull(updatedUser.getModificationTime());
		assertTrue(
				"Modification date must be after creation date",
				updatedUser.getModificationTime().compareTo(
						updatedUser.getCreationTime()) > 0);
		assertEquals(newFirstName, updatedUser.getFirstName());
	}

	private static User createValidUser(String email, String firstName,
			String lastName) {
		User result = new User();
		result.setEmail(email);
		result.setFirstName(firstName);
		result.setLastName(lastName);
		return result;
	}
}
