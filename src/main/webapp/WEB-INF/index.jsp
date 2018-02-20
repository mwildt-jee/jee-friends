<%@ page import="de.hsw.jee.friends.model.*" %>
<%@ page import="java.util.*" %>

<html>
	<head>
	
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
		<title>Friends</title>
		
	</head>
	<body>
		
		<jsp:include page="navigation.jsp" />
		
		<div class="container container-fluid">
		
			<h1>Welcome to Friends</h1>
				
			<h2>&Uuml;ersicht</h2>
			
			<div class="row">
				
				<%
				final Set<Profile> followed = (Set<Profile>) request.getAttribute("followed");
				for(Profile profile : (List<Profile>) request.getAttribute("profile")) {
				%>
					<div class="col-lg-3">
						<h3><%= profile.getDisplayName() %></h3>
						
						<% if(!followed.contains(profile)) {%>
							<form method="POST" action="<%=request.getContextPath()%>/profile/follow">
								<input type="hidden" name="profileToFollow" value="<%= profile.getId() %>" />
								
								<input type="submit" value="Folgen">
							</form>					
						<% } %>
								
					</div>
					
				<% } %>
			</div>
		</div>
		
	</body>

</html>

