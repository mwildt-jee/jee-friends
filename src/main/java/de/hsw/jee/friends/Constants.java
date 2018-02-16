package de.hsw.jee.friends;

public class Constants {

	public static final String JSP_FILE_EXTENSION= ".jsp";
	public static final String WEB_INF= "/WEB-INF";
	
	public static final String USER_SESSION_ATTR = "user";
	
	public static String jsp(final String path) {
		return WEB_INF + path + JSP_FILE_EXTENSION;
	}
}
