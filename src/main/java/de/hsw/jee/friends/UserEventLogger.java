package de.hsw.jee.friends;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hsw.jee.friends.interceptor.Trace;

@ApplicationScoped
public class UserEventLogger {
	
	private final Logger LOG = LoggerFactory.getLogger(UserEventLogger.class);
	
	@Trace
	public void onUserCreated(@Observes CreateUserEvent event) {
		LOG.info("On Create User {}", event.getUser());
	}

}
