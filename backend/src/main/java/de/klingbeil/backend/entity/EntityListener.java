package de.klingbeil.backend.entity;

import java.util.Collection;

import javax.persistence.PrePersist;

import org.springframework.context.ApplicationContext;

import de.klingbeil.backend.spring.ApplicationContextProvider;

@SuppressWarnings({"rawtypes", "unchecked"})
public class EntityListener {

	@PrePersist
	public void prePersist(Object entity) {
		Collection<PrePersistCallback> registeredCallbacks = getRegisteredCallbacks(PrePersistCallback.class);
		for (PrePersistCallback callback : registeredCallbacks) {
			if (entityTypeMatches(entity, callback)) {
				callback.prePersist(entity);
			}
		}
	}

	private static boolean entityTypeMatches(Object entity,
			EntityCallback callback) {
		return callback.getEntityType().isAssignableFrom(entity.getClass());
	}

	private static <T> Collection<T> getRegisteredCallbacks(
			Class<T> callbackType) {
		return getApplicationContext().getBeansOfType(callbackType).values();
	}

	private static ApplicationContext getApplicationContext() {
		return ApplicationContextProvider.getApplicationContext();
	}

}