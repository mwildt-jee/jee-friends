package de.hsw.jee.friends.repository.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.UserRepository;

public class UserRepositoryMock implements UserRepository{

	private final List<User> users = new ArrayList<>();
	private Long idSequence = 0L; 
	
	@Override
	public Optional<User> find(Long id) {
		return this.users.stream().filter(u -> Objects.equals(u.getId(), id)).findFirst();
	}
	
	@Override
	public Optional<User> findByUserName(String username) {
		return this.users.stream().filter(u -> Objects.equals(u.getUsername(), username)).findFirst();
	}

	@Override
	public User save(User user) {
		if(Objects.isNull(user.getId())) {
			user.setId(++idSequence);
		}
		this.users.add(user);
		return user;
	}

	@Override
	public List<User> findAll() {
		return Collections.unmodifiableList(this.users);
	}

}
