<%@ page import="de.hsw.jee.friends.model.*" %>
<%@ page import="java.util.*" %>

<nav class="navbar navbar-default">
	<div class="container container-fluid">
		<div class="navbar-header">
			
			<ul class="nav navbar-nav">
			
				<% if(request.getAttribute("user") != null) { %>
					<li role="presentation"><a href="<%=request.getContextPath()%>">Startseite</a></li>
					<li role="presentation"><a href="<%=request.getContextPath()%>/profile">Mein Profil</a></li>
					
					
					<li role="presentation"><a href="<%=request.getContextPath()%>/auth/logout">Logout</a></li>
				<% } %>
			
				<% if(request.getAttribute("user") == null) { %>
					<li role="presentation"><a href="<%=request.getContextPath()%>/auth/login">Login</a></li>
				<% } %>				
				
				<li role="presentation"><a href="<%=request.getContextPath()%>/auth/register">Registrieren</a></li>

			</ul>
				
		</div>
	</div>
</nav>