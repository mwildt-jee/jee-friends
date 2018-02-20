package de.hsw.jee.friends.services;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ApplicationScoped
public class UserService {

	private final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Inject private UserRepository userRepository;
	@Inject private PasswordEncoder passswordEncoder;
	
	/**
	 * Erzeugt einen neuen Benutzer
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public User createUser(String username, String password) {
		Optional<User> userOpt = userRepository.findByUserName(username);
		if(userOpt.isPresent()) {
			return null;
		} else {
			LOG.info("create new user with name {}", username);
			final User user = new User();
			user.setUsername(username);
			user.setPassword(this.passswordEncoder.encode(password));
			return userRepository.save(user);
		}
		
	}

	public boolean noUserExists() {
		return userRepository.findAll().isEmpty();
	}
	
}
