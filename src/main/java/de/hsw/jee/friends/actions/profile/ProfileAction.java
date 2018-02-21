package de.hsw.jee.friends.actions.profile;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.jee.friends.Constants;
import de.hsw.jee.friends.SessionContext;
import de.hsw.jee.friends.model.Message;
import de.hsw.jee.friends.model.Notification;
import de.hsw.jee.friends.model.Profile;
import de.hsw.jee.friends.services.MessageService;
import de.hsw.jee.friends.services.NotificationService;
import de.hsw.jee.friends.services.RelationService;

@WebServlet("/profile")
public class ProfileAction extends HttpServlet {

	@Inject private RelationService relationService;
	@Inject private MessageService messageService;
	@Inject private SessionContext sessionContext;
	@Inject private NotificationService notificationService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		final List<Message> messages = messageService.findByProfile(sessionContext.getUser().getProfile()).stream()
				.sorted(Comparator.comparing(Message::getCreated).reversed())
				.collect(Collectors.toList());
		req.setAttribute("messages", messages);
		
		final Set<Profile> followed = relationService.getFollowedProfiles(sessionContext.getUser());
		req.setAttribute("followed", followed);
		
		final Set<Profile> following = relationService.getFollowingProfiles(sessionContext.getUser());
		req.setAttribute("following", following);
		
		final List<Notification> notifications = notificationService.findFirstByUser(10, sessionContext.getUser());
		req.setAttribute("notifications", notifications);
		
		req.getRequestDispatcher(Constants.jsp("/profile")).forward(req, resp);
	}
	
}
