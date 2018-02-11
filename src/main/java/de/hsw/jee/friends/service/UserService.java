package de.hsw.jee.friends.service;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hsw.jee.friends.CreateUserEvent;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.UserRepository;

@ApplicationScoped
public class UserService {
	
	private final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Inject
	private Event<CreateUserEvent> createUserEvent;
	
	@Inject
	private UserRepository repository;
	
	@Inject
	private PasswordEncoder passwordEncoder;	

	public User createUser(String username, String password) {
		final User user = new User();
		user.setUsername(username);
		user.setPassword(this.passwordEncoder.encode(password));
		this.repository.save(user);
		LOG.info("Create new User: {}", user);
		createUserEvent.fire(new CreateUserEvent(user));
		return user;
	}

	public Optional<User> getUser(final String username) {
		return repository.findByUserName(username);
	}

}
