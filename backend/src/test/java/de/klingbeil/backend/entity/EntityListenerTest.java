package de.klingbeil.backend.entity;

import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.klingbeil.backend.config.ApplicationContextAware;
import de.klingbeil.backend.config.ApplicationContextBackendTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextBackendTest.class,
		ApplicationContextAware.class})
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

}
