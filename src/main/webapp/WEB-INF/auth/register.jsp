<html>
	<head>
	
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
		<title>Registrieren</title>
		
	</head>
	<body>

		<jsp:include page="../navigation.jsp" />
		
		<div class="container container-fluid">
		
			<h1>Registrieren</h1>
			
			<div>
				
				<form class="form" method="POST" action="<%=request.getContextPath()%>/auth/register">
	
					<div class="form-group">
						<label for="username">Benutzername</label> 
						<input class="form-control" id="username" name="username" placeholder="Username">
					</div>
	
					<div class="form-group">
						<label for="password">Passwort</label> 
						<input type="password" name="password" class="form-control" id="password" placeholder="Passwort">
					</div>
					
					<div class="form-group">
						<label for="repassword">Passwort wiederholen</label> 
						<input type="password" name="repassword" class="form-control" id="repassword" placeholder="Passwort">
					</div>
					
					<div class="form-group">
						<label for="firstname">Vorname</label> 
						<input name="firstname" class="form-control" id="firstname" placeholder="Vorname">
					</div>
					
					<div class="form-group">
						<label for="lastname">Nachname</label> 
						<input name="lastname" class="form-control" id="lastname" placeholder="Nachname">
					</div>
					
					<button class="btn btn-primary" type="submit">Registrieren</button>
				</form>
			</div>
			
		</div>
		
	</body>

</html>