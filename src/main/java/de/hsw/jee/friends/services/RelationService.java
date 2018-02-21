package de.hsw.jee.friends.services;

import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import de.hsw.jee.friends.model.Profile;
import de.hsw.jee.friends.model.User;

@ApplicationScoped
public class RelationService {
	
	/**
	 * Erzeugt eine neue Follow-Vernknüpfung zwischen einem Profil (dem gefolgt wird) und einem User (dem, der folgt)
	 * @param profiletoFollow
	 * @param follower
	 */
	public void follow(Profile profiletoFollow , User follower) {
		follower.getFollowed().add(profiletoFollow);
		profiletoFollow.getFollowing().add(follower);
	}

	/**
	 * Lesen der Benutzer, denen der übergebene Benutzer folgt
	 * @param user
	 * @return
	 */
	public Set<Profile> getFollowedProfiles(User user) {
		return user.getFollowed();
	}
	
	/**
	 * Lesen der Benutzer, die dem übergenenen User folgen
	 * @param user
	 * @return
	 */
	public Set<Profile> getFollowingProfiles(User user) {
		return user.getProfile().getFollowing().stream().map(User::getProfile).collect(Collectors.toSet());
	}


}
