<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Authentification</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link  rel="stylesheet" href="css/site.css" />
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="span3">
				<div class="well" style="padding: 8px 0;">
	
				</div>
			</div>
			<div class="span9">
				<div id="login-page" class="container">
					<strong class="msg-info">${msg}</strong>
					<form id="login-form" class="well" action="LoginServlet"
						method="post">
						<input type="text" name="login" placeholder="Login" required /><br>
						<input type="password" name="psw" placeholder="Password" required /><br>
						<button type="submit" class="btn btn-primary">Login in</button>
					</form>
				</div>
			</div>
		</div>

	</div>


</body>
</html>