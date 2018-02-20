package de.hsw.jee.friends.repository;

import java.util.List;
import java.util.Optional;

import de.hsw.jee.friends.model.Profile;
import de.hsw.jee.friends.model.User;

public interface ProfileRepository {

	Profile findByOwner(User owner);
	
	Profile save(Profile profile);
	
	List<Profile> findAll();

	Optional<Profile> findById(long id);
	
}
