package de.hsw.jee.friends.services;

import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;


/**
 * Klasse für die Hash-Berechnung des Passwortes.
 * 
 * TODO: Hier sollte noch ein passender Algorithmus verwendet werden.
 * 
 * @author mwildt
 *
 */
@ApplicationScoped
public class PasswordEncoder {

	public String encode(String password) {
		return password;
	}
	
	public boolean check(String encodecPassword, String password) {
		return Objects.equals(encodecPassword, password);
	}
	
}
