package de.hsw.jee.friends.actions;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.jee.friends.Bootstrap;
import de.hsw.jee.friends.Constants;
import de.hsw.jee.friends.repository.ProfileRepository;

import java.io.IOException;

@WebServlet("/") 
public class IndexAction extends HttpServlet {
	
	@Inject private ProfileRepository profileRepository;
	@Inject private Bootstrap bootstrap;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// lesen der Daten für die Anzeige
		req.setAttribute("profile", profileRepository.findAll());
		
		// aufrufen der JSP-Seite
		req.getRequestDispatcher(Constants.jsp("/index")).forward(req, resp);
	}

}
