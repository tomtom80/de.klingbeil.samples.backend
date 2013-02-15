package de.klingbeil.backend.entity;

import java.util.Collection;

import javax.persistence.PrePersist;

import org.springframework.context.ApplicationContext;

import de.klingbeil.backend.spring.ApplicationContextProvider;

public class EntityListener {

	@PrePersist
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void prePersist(Object entity) {
		Collection<PrePersistCallback> registeredCallbacks = getRegisteredCallbacks(PrePersistCallback.class);
		for (PrePersistCallback callback : registeredCallbacks) {
			callback.prePersist(entity);
		}
	}

	private static <T> Collection<T> getRegisteredCallbacks(
			Class<T> callbackType) {
		return getApplicationContext().getBeansOfType(callbackType).values();
	}

	private static ApplicationContext getApplicationContext() {
		return ApplicationContextProvider.getApplicationContext();
	}

}
