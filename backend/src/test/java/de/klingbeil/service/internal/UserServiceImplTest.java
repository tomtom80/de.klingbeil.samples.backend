package de.klingbeil.service.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.klingbeil.model.User;
import de.klingbeil.repository.UserRepository;

public class UserServiceImplTest {

	private UserServiceImpl service;
	@Mock
	private UserRepository userRepository;
	private Long id;
	private String firstName;
	private String lastName;
	private String eMail;
	private User user;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new UserServiceImpl();
		service.userRepository = userRepository;
		id = Long.valueOf(3324);
		firstName = "Blub";
		lastName = "Bla";
		eMail = "tom@tom.de";
		user = createUser(id, firstName, lastName, eMail);
		when(userRepository.findOne(id)).thenReturn(user);
	}

	@Test
	public void testCreate() throws Exception {

		service.create(user);

		ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
		verify(userRepository).save(captor.capture());
		User capturedUser = captor.getValue();
		assertUserEquals(capturedUser);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateWithNull() throws Exception {
		service.create(null);
	}

	@Test
	public void testDelete() throws Exception {

		service.delete(id);

		ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
		verify(userRepository).delete(captor.capture());
		assertUserEquals(user);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteWithNull() throws Exception {
		service.delete(null);
	}

	@Test
	public void testDeleteWithNotExitingUser() throws Exception {
		Long notExistingId = Long.valueOf(-1);
		doThrow(new IllegalArgumentException()).when(userRepository).findOne(
				notExistingId);

		try {
			service.delete(notExistingId);
		} catch (IllegalArgumentException expected) {
		}
	}

	@Test
	public void testFindById() throws Exception {

		User foundUser = service.findById(id);

		assertUserEquals(foundUser);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindByIdWithNull() throws Exception {
		service.findById(null);
	}

	@Test
	public void testFindByIdNotFound() throws Exception {
		Long notExistingId = Long.valueOf(-1);
		doThrow(new IllegalArgumentException()).when(userRepository).findOne(
				notExistingId);

		try {
			service.findById(notExistingId);
		} catch (IllegalArgumentException expected) {
		}
	}

	private void assertUserEquals(User actualUser) {
		assertSame(id, actualUser.getId());
		assertEquals(firstName, actualUser.getFirstName());
		assertEquals(lastName, actualUser.getLastName());
		assertEquals(eMail, actualUser.getEmail());
	}

	private User createUser(Long id, String firstName, String lastName,
			String eMail) {
		User result = new User();
		result.setId(id);
		result.setFirstName(firstName);
		result.setLastName(lastName);
		result.setEmail(eMail);
		return result;
	}
}
