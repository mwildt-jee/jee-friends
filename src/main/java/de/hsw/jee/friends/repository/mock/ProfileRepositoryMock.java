package de.hsw.jee.friends.repository.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;

import de.hsw.jee.friends.interceptor.Trace;
import de.hsw.jee.friends.model.Profile;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.ProfileRepository;

@ApplicationScoped
public class ProfileRepositoryMock implements ProfileRepository {
	
	private final List<Profile> profiles = new ArrayList<>();
	
	
	
	@Override
	public Profile findByOwner(User user) {
		return profiles.stream()
			.filter(p -> Objects.equals(p.getOwner(), user))
			.findFirst()
			.orElse(null);
	}


	@Trace
	@Override
	public Profile save(Profile profile) {
		if(Objects.isNull(profile.getOwner())) {
			throw new RuntimeException("Null Constraint Violation Exception on field 'owner'");
		}
		this.profiles.add(profile);
		return profile;
	}

	@Override
	public List<Profile> findAll() {
		return Collections.unmodifiableList(this.profiles);
	}

}
