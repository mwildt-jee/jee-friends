package de.hsw.jee.friends.actions;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.jee.friends.Constants;
import de.hsw.jee.friends.model.Profile;
import de.hsw.jee.friends.repository.ProfileRepository;


@WebServlet("/") 
public class IndexAction extends HttpServlet {
	
	@Inject private ProfileRepository profileRepository;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Profile> profiles = profileRepository.findAll();
		req.setAttribute("profiles", profiles);
		
		req.getRequestDispatcher(Constants.WEB_INF + "index.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
