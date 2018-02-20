package de.hsw.jee.friends.actions.profile;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
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
import de.hsw.jee.friends.services.MessageService;

@WebServlet("/profile")
public class ProfileAction extends HttpServlet {

	@Inject private MessageService messageService;
	@Inject private SessionContext sessionContext;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		final List<Message> messages = messageService.findByUser(sessionContext.getUser()).stream()
				.sorted(Comparator.comparing(Message::getCreated).reversed())
				.collect(Collectors.toList());
		
		req.setAttribute("messages", messages);
		
		req.getRequestDispatcher(Constants.jsp("/profile")).forward(req, resp);
	}
	
}