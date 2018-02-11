package de.hsw.jee.friends.service;

import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PasswordEncoder {
	
	public String encode(String password) {
		return password;
	}
	
	public boolean check(String encoded, String password) {
		return Objects.equals(encoded, password);
	}

}
