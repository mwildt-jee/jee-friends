<%@ page import="de.hsw.jee.friends.model.Profile" %>
<%@ page import="java.util.List" %>
<html>
	<head>
	
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
		<title>Login</title>
	</head>
	<body>
		
		<div class="container container-fluid">
		
			<h1>Welcome to Friend</h1>
						
			<div class="row">
			
				<% for(Profile p : (List<Profile>)request.getAttribute("profiles")) {%>
					<div class="col-lg-3 panel panel default">
						<h3><%=p.getFirstname() %> <%=p.getLastname()%></h3>
					</div>
				<% } %>
				
			</div>
		</div>
		
	</body>

</html>