package de.hsw.jee.friends.repository;

import java.util.List;

import de.hsw.jee.friends.model.Message;
import de.hsw.jee.friends.model.User;

public interface MessageRepository {

	Message save(Message message);
	
	List<Message> findByUser(User user);
	
	
}
