package de.hsw.jee.friends.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hsw.jee.friends.Constants;

@WebFilter("/*") 
public class AuthFilter implements Filter{

	private static final Logger LOG = LoggerFactory.getLogger(AuthFilter.class);  
	
	private static final String REDIRECT_PATH = "/auth/login";
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest httpRequest = HttpServletRequest.class.cast(req);
		final boolean authenticated = Objects.nonNull(httpRequest.getSession().getAttribute(Constants.USER_SESSION_ATTR)); 
		
		if (!httpRequest.getServletPath().startsWith("/auth") && !authenticated) {
			LOG.info("unauthorized Request to {}, send redirect to {}", httpRequest.getServletPath(), REDIRECT_PATH);
			HttpServletResponse.class.cast(resp).sendRedirect(httpRequest.getContextPath() + REDIRECT_PATH);
		} else {
			chain.doFilter(req, resp);
		}
		
	}
	
}
