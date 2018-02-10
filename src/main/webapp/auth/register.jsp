<html>
	<head>
	
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
		<title>Login</title>
	</head>
	<body>
		
		<div class="container container-fluid">
		
			<h1>Registrieren</h1>
			
			<div>
				
				<form class="form" method="POST" action="<%=request.getContextPath()%>/auth/register">
	
					<div class="form-group">
						<label for="username">Username</label> 
						<input type="username" class="form-control" id="username" placeholder="Username">
					</div>
	
					<div class="form-group">
						<label for="password">Password</label> 
						<input type="password" class="form-control" id="password" placeholder="Password">
					</div>
	
					<button class="btn btn-primary" type="submit">Registrieren</button>
				</form>
			</div>
			
		</div>
		
	</body>

</html>