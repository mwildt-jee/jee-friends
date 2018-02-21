package de.hsw.jee.friends.model;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Long id;
	private String username;
	private String password;
	private Profile profile;
	
	
	/* Die Profile, denen der Nutzer Folgt */
	private Set<Profile> followed = new HashSet<>();
	
	private Set<Notification> notifications = new HashSet<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
		if(profile.getOwner() != this){
			profile.setOwner(this);
		}
	}

	public Set<Profile> getFollowed() {
		return followed;
	}

	public void setFollowed(Set<Profile> followed) {
		this.followed = followed;
	}
	
	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

}
