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

@WebServlet("/auth/logout") 
public class logoutAction extends HttpServlet {

	private static final Logger LOG = LoggerFactory.getLogger(logoutAction.class);

	@Inject private  SessionContext sessionContext;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sessionContext.setUser(null);
		resp.sendRedirect(req.getContextPath());
		req.getSession().invalidate();
	}

}
