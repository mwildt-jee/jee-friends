package de.hsw.jee.friends.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import de.hsw.jee.friends.model.Profile;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.ProfileRepository;

@ApplicationScoped
public class ProfileService {

	@Inject private ProfileRepository profileRepository;

	
	/**
	 * Erzeugt ein neues Profil
	 * @param user
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	public Profile createProfile(User user, String firstname, String lastname) {
		Profile profile = new Profile();
		profile.setOwner(user);
		profile.setFirstName(firstname);
		profile.setLastName(lastname);
		return profileRepository.save(profile);
	}	
	
}
