package de.hsw.jee.friends.actions.auth;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.jee.friends.Constants;
import de.hsw.jee.friends.model.Profile;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.ProfileRepository;
import de.hsw.jee.friends.service.UserService;

@WebServlet("/auth/register") 
public class RegisterAction extends HttpServlet {
	
	@Inject
	private UserService userService;
	
	@Inject
	private ProfileRepository profileRepository;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Constants.WEB_INF + "/auth/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");
		final User user = this.userService.createUser(username, password);
	
		final Profile profile = new Profile();
		profile.setOwner(user);
		profile.setFirstname(req.getParameter("firstname"));
		profile.setLastname(req.getParameter("lastname"));
		profileRepository.save(profile);
		
		if(user != null) {
			if(req.getSession().getAttribute(Constants.USER_SESSION_ATTR) != null) {
				resp.sendRedirect(req.getContextPath() + "/");
			} else {
				resp.sendRedirect(req.getContextPath() + "/auth/login");	
			}
		} else {
			doGet(req, resp);
		}
	}

}
