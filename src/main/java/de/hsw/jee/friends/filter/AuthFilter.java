package de.hsw.jee.friends.filter;

import java.io.IOException;
import java.util.Objects;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.jee.friends.SessionContext;

@WebFilter("/*") 
public class AuthFilter implements Filter{

	@Inject private  SessionContext sessionContext;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = HttpServletRequest.class.cast(req);
		boolean authenticated = Objects.nonNull(sessionContext.getUser()); 
		if (!httpRequest.getServletPath().startsWith("/auth") && !authenticated) {
			String loginPath = httpRequest.getContextPath() + "/auth/login";
			HttpServletResponse.class.cast(resp).sendRedirect(loginPath);
		} else {
			req.setAttribute("user", sessionContext.getUser());
			chain.doFilter(req, resp);
		}
		
	}

}
