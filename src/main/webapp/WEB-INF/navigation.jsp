<nav class="navbar navbar-default">
	<div class="container container-fluid">
		<div class="navbar-header">
			
			<ul class="nav navbar-nav">
			
				<% if(session.getAttribute("user") == null) { %>
					<li role="presentation"><a href="<%=request.getContextPath()%>/auth/login">Login</a></li>
				<% } %>
				
				<li role="presentation"><a href="<%=request.getContextPath()%>/auth/register">Registrieren</a></li>
			
			</ul>
				
		</div>
	</div>
</nav>