package de.hsw.jee.friends.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import de.hsw.jee.friends.model.Message;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.MessageRepository;

@ApplicationScoped
public class MessageService {

	@Inject private MessageRepository messageRepository;
	
	public Message save(Message message) {
		return messageRepository.save(message);
	}
	
	public List<Message> findByUser(User user) {
		return messageRepository.findByUser(user);
	}

}
