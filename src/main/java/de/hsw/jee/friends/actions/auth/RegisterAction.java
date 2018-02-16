package de.hsw.jee.friends.actions.auth;

import java.io.IOException;
import java.util.Objects;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hsw.jee.friends.Constants;
import de.hsw.jee.friends.model.Profile;
import de.hsw.jee.friends.model.User;
import de.hsw.jee.friends.repository.ProfileRepository;
import de.hsw.jee.friends.services.UserService;

@WebServlet("/auth/register") 
public class RegisterAction extends HttpServlet {
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginAction.class);
	
	@Inject private UserService userService;
	@Inject private ProfileRepository profileRepository;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Constants.jsp("/auth/register"))
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");
		final String repassword = req.getParameter("repassword");
		
		if(Objects.equals(password, repassword)) {
			User user = userService.createUser(username, password);	
			if(user != null) {
				createProfile(user, req.getParameter("firstname"), req.getParameter("lastname"));
				resp.sendRedirect(req.getContextPath() + "/auth/login");
			} else {
				// TODO Fehlerhandling
				LOG.error("Der Benutzer mit Namen {} konnte nicht erzeigt werden", username);
				doGet(req, resp);
			}
		} else {
			// TODO Fehlerhandling
			LOG.error("Der Benutzer mit Namen {} konnte nicht erzeigt werden weil die Passworte nicht übereinstimmen", username);
			doGet(req, resp);
		}
	}

	private Profile createProfile(User user, String firstname, String lastname) {
		Profile profile = new Profile();
		profile.setOwner(user);
		profile.setFirstName(firstname);
		profile.setLastName(lastname);
		return profileRepository.save(profile);
	}
	
}
