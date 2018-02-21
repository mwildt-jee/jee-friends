package de.hsw.jee.friends.repository.mock;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import de.hsw.jee.friends.model.Notification;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.NotificationRepository;

@ApplicationScoped
public class NotificationRepositoryMock implements NotificationRepository {

	private final List<Notification> data = new LinkedList<>();
	
	private Long idSequence = 0L; 
	
	@Override
	public Notification save(Notification notification) {
		notification.setId(++idSequence);
		data.add(notification);
		return notification;
	}

	@Override
	public Set<Notification> findByUser(User user) {
		return user.getNotifications();
	}


	
}
