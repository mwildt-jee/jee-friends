package de.hsw.jee.friends.actions.profile;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.jee.friends.SessionContext;
import de.hsw.jee.friends.model.Message;
import de.hsw.jee.friends.services.MessageService;

@WebServlet("/profile/messages")
public class MessageAction extends HttpServlet {

	@Inject private MessageService messageSevice;
	@Inject SessionContext sessionContext;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Message message = new Message();
		
		message.setProfile(sessionContext.getUser().getProfile());
		message.setMessage(req.getParameter("message"));
		messageSevice.save(message);
		
		resp.sendRedirect(req.getContextPath() + "/profile");
	}
	
}
