package de.klingbeil.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user;

	@Before
	public void setUp() {
		user = new User();
	}
	
	@Test
	public void testFirstName() {
		String firstName = "Hans";
		
		user.setFirstName( firstName );
		
		assertEquals( firstName, user.getFirstName());
	}

	@Test
	public void testLastName() throws Exception {
		String lastName = "Wurst";
		
		user.setLastName( lastName);
		
		assertEquals( lastName , user.getLastName());
	}
	
	@Test
	public void testEmail() throws Exception {
		String eMail = "tom@klingbeil.de";
		
		user.setEmail( eMail);
		
		assertEquals( eMail, user.getEmail());
	}

	
}
