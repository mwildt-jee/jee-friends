package de.hsw.jee.friends.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profile {

	private Long id;
	private User owner;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;

	private List<User> following = new ArrayList<User>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
		if(owner.getProfile() != this) {
			owner.setProfile(this);
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
	public String getDisplayName() {
		return getFirstName() + " " + getLastName();
	}

	public List<User> getFollowing() {
		return following;
	}

	public void setFollowing(List<User> following) {
		this.following = following;
	}

	public boolean isOwner(User user) {
		return Objects.equals(user, this.getOwner());
	}
}
