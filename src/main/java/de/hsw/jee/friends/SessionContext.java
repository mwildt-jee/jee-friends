package de.hsw.jee.friends;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import de.hsw.jee.friends.model.User;

@SessionScoped
public class SessionContext implements Serializable{

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
