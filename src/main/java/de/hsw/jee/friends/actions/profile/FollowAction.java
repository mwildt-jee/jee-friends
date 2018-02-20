package de.hsw.jee.friends.actions.profile;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.jee.friends.SessionContext;
import de.hsw.jee.friends.services.ProfileService;
import de.hsw.jee.friends.services.RelationService;
import de.hsw.jee.friends.services.UserService;

@WebServlet("/profile/follow")
public class FollowAction extends HttpServlet {

	@Inject private RelationService relationService;
	@Inject private ProfileService profileService;
	@Inject private SessionContext sessionContext;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		profileService.findById(Long.parseLong(req.getParameter("profileToFollow")))
			.ifPresent(toFollow -> {
				relationService.follow(toFollow, sessionContext.getUser());
			});
		
		resp.sendRedirect(req.getContextPath() + "/index");
	}
	
}
