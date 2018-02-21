package de.hsw.jee.friends.services;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import de.hsw.jee.friends.model.Message;
import de.hsw.jee.friends.model.Profile;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.MessageRepository;

@ApplicationScoped
public class MessageService {

	@Inject private MessageRepository messageRepository;
	@Inject private Event<Message> messageEvent;
	
	public Message save(Message message) {
		messageRepository.save(message);
		messageEvent.fire(message);
		return message;
	}
	
	public List<Message> findByUser(User user) {
		return messageRepository.findByUser(user);
	}

	public List<Message> findByProfile(Profile profile) {
		return messageRepository.findByProfile(profile);
	}

}
