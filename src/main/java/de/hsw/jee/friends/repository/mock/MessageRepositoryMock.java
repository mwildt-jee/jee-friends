package de.hsw.jee.friends.repository.mock;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import de.hsw.jee.friends.model.Message;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.MessageRepository;

@ApplicationScoped
public class MessageRepositoryMock implements MessageRepository {

	private final List<Message> data = new LinkedList<>();
	
	private Long idSequence = 0L; 
	
	@Override
	public Message save(Message message) {
		message.setId(++idSequence);
		data.add(message);
		return message;
	}

	@Override
	public List<Message> findByUser(User user) {
		return data.stream()
			.filter(m -> m.getUser().equals(user))
			.collect(Collectors.toList());
	}	
	
}
