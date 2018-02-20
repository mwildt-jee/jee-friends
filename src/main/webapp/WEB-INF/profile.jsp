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
		
			<h1><%= ((User)request.getAttribute("user")).getUsername() %>'s Profile</h1>
			
			<div class="row">
			
				<div class="col-xs-8">
			
					<div class="panel panel-default">
						<div class="panel-heading">
						 	<h2 class="panel-title">Was hast du zu sagen</h2>
						</div>
					
						<div class="panel-body">
								
							<form class="form" method="POST" action="<%=request.getContextPath()%>/profile/messages" >
				
								<div class="form-group">
									<label for="username"></label> 
									<textarea name="message" class="form-control"></textarea>
								</div>
				
								<button class="btn btn-primary" type="submit">Veröffentlichen</button>
								
							</form>
							
						</div>
								
					</div>
					
					<% for(Message message : (List<Message>) request.getAttribute("messages")) { %>
					
						<div class="well">
							
							<div class="panel-body">
								<h4>Von <%= message.getUser().getUsername() %> <small> <%= message.getCreated() %> </small></h4>
									
								<%= message.getMessage() %>
								
							</div>
									
						</div>
						
					<% } %>
							
				</div>
	
				<div class="col-xs-4">
				
					<div class="panel panel-default">
						<div class="panel-heading"><h4 class="panel-title">Du folgst (<%= ((Set<Profile>) request.getAttribute("followed")).size() %>)</h4> 
						</div>
						<div class="panel-body">
							<ul>
								<% for(Profile profil : (Set<Profile>) request.getAttribute("followed")) { %>
									<li><%= profil.getDisplayName() %></li>	
								<% } %>
							</ul>
						</div>
					</div>
					
					<div class="panel panel-default">
						<div class="panel-heading"><h4 class="panel-title">Dir folgen (<%= ((Set<Profile>) request.getAttribute("following")).size() %>)</h4></div>
						<div class="panel-body">
							<ul>
								<% for(Profile profil : (Set<Profile>) request.getAttribute("following")) { %>
									<li><%= profil.getDisplayName() %></li>	
								<% } %>
							</ul>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</body>

</html>