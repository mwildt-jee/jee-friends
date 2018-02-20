package de.hsw.jee.friends.actions.auth;

import java.io.IOException;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hsw.jee.friends.Constants;
import de.hsw.jee.friends.SessionContext;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.UserRepository;
import de.hsw.jee.friends.services.PasswordEncoder;

@WebServlet("/auth/login") 
public class LoginAction extends HttpServlet {

	private static final Logger LOG = LoggerFactory.getLogger(LoginAction.class);
	
	@Inject private UserRepository userRepository;
	@Inject private PasswordEncoder passwordEncoder;
	@Inject private  SessionContext sessionContext;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Constants.jsp("/auth/login"))
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");
		
		final User user =  userRepository.findByUserName(username)
			.filter(u -> passwordEncoder.check(u.getPassword(), password))
			.orElse(null);
		
		if(user != null) {
			LOG.info("User with name {} cannont be logged in", username);
			sessionContext.setUser(user);
			resp.sendRedirect(req.getContextPath());
		} else {
			// TODO Fehlerhandling
			doGet(req, resp);
		}
	}

}
