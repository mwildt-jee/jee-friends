package de.hsw.jee.friends.services;

import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import de.hsw.jee.friends.model.Profile;
import de.hsw.jee.friends.model.User;

@ApplicationScoped
public class RelationService {
	
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
		// liest alle Profile, denen der Nutzer folgt
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
