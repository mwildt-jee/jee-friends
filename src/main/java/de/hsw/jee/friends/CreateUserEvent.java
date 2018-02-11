package de.hsw.jee.friends;

import de.hsw.jee.friends.model.User;

public class CreateUserEvent {

	private final User user;
	
	public CreateUserEvent(User user){
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
}
