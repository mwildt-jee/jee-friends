package de.hsw.jee.friends.actions.auth;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import de.hsw.jee.friends.Constants;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.service.PasswordEncoder;
import de.hsw.jee.friends.service.UserService;

@WebServlet("/auth/login") 
public class LoginAction extends HttpServlet {
	
	private Logger LOG = LoggerFactory.getLogger(LoginAction.class);
	
	@Inject
	private UserService userService;
	
	@Inject
	private PasswordEncoder passwordEncoder;	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Constants.WEB_INF + "/auth/login.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		final String username = req.getParameter("username");
		final Optional<User> userOpt = this.userService.getUser(username);
		
		if(userOpt.isPresent()) {
			final User user = userOpt.get();
			final String password = req.getParameter("password");
			
			if(this.passwordEncoder.check(user.getPassword(), password)) {
				req.getSession().setAttribute(Constants.USER_SESSION_ATTR, user);
				LOG.info("User {} is logged in", user);
				resp.sendRedirect(req.getContextPath());
			} else {
				LOG.info("Password check was not successful for {}", user);
				doGet(req, resp);
			}

		} else {
			LOG.info("User with name {} was not found", username);
			doGet(req, resp);
		}
		
		
	}

}
