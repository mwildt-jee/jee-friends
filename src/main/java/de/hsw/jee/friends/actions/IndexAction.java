package de.hsw.jee.friends.actions;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.jee.friends.Bootstrap;
import de.hsw.jee.friends.Constants;
import de.hsw.jee.friends.SessionContext;
import de.hsw.jee.friends.repository.ProfileRepository;
import de.hsw.jee.friends.services.RelationService;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/") 
public class IndexAction extends HttpServlet {
	
	@Inject private RelationService relationService;
	@Inject private SessionContext sessionContext;
	@Inject private ProfileRepository profileRepository;
	@Inject private Bootstrap bootstrap;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// lesen der Daten für die Anzeige (Das eigene Profil soll hier nicht angezeigt werden)
		
		req.setAttribute("profile", profileRepository.findAll().stream()
				.filter(p -> !p.isOwner(sessionContext.getUser()))
				.collect(Collectors.toList()));
		
		req.setAttribute("followed", relationService.getFollowedProfiles(sessionContext.getUser()));
		// aufrufen der JSP-Seite
		req.getRequestDispatcher(Constants.jsp("/index")).forward(req, resp);
	}

}
