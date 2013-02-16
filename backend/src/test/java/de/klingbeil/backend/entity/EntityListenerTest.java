package de.klingbeil.backend.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.klingbeil.backend.model.User;
import de.klingbeil.config.context.ApplicationContextBackend;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextBackend.class})
public class EntityListenerTest {

	private EntityListener listener;
	@Resource
	private TestCallback testCallback;

	@Before
	public void setUp() {
		listener = new EntityListener();
	}

	@Test
	public void testPrePersistCallback() {
		listener.prePersist(new TestEntity());

		assertTrue(testCallback.isCalled());
	}

	@Test
	public void testPrePersistCallbackWithSubEntity() {
		listener.prePersist(new TestEntitySubClass());

		assertTrue(testCallback.isCalled());
	}

	@Test
	public void testPrePersistCallbackWithNotMatchingEntityType() {
		listener.prePersist(new User());

		assertFalse(testCallback.isCalled());
	}

}
