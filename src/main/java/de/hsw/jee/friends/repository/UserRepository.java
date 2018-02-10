package de.hsw.jee.friends.repository;

import java.util.List;
import java.util.Optional;

import de.hsw.jee.friends.model.User;

public interface UserRepository {
	
	Optional<User> find(Long id);
	
	Optional<User> findByUserName(String username);
	
	User save(User user);
	
	List<User> findAll();

}
