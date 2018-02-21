package de.hsw.jee.friends.repository;

import java.util.Set;

import de.hsw.jee.friends.model.Notification;
import de.hsw.jee.friends.model.User;

public interface NotificationRepository {

	Notification save(Notification notification);

	Set<Notification> findByUser(User user);

}
