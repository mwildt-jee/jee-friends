package de.hsw.jee.friends.services;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import de.hsw.jee.friends.model.Message;
import de.hsw.jee.friends.model.Notification;
import de.hsw.jee.friends.model.Profile;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.NotificationRepository;

@ApplicationScoped
public class NotificationService {

	@Inject private NotificationRepository notificationRepository;
	@Inject private RelationService relationService;
	
	/**
	 * Erzeugt eine Notification für alls Follower des Benutzers, wenn eine Neue Nachticht erzeugt wurde.
	 * @param message
	 */
	public void onMessage(@Observes final Message message) {
		final Set<Profile> profiles = relationService.getFollowingProfiles(message.getProfile().getOwner());
			
		profiles.stream()
			.map(Profile::getOwner)
			.forEach(user -> createNotification(user, message));
	}

	
	public List<Notification> findFirstByUser(int limit, User user){
		return notificationRepository.findByUser(user).stream()
			.sorted(Comparator.comparing(Notification::getCreated).reversed())
			.limit(limit)
			.collect(Collectors.toList());
	}
	
	/**
	 * erzeugt und speichert eine Notification zu einer MEssage und einem Benutzer
	 * @param user
	 * @param message
	 */
	private void createNotification(User user, Message message) {
		Notification notification = new Notification();
		notification.setMessage(message);
		notification.setTarget(user);
		user.getNotifications().add(notification);
		notificationRepository.save(notification);
	}
	
}
