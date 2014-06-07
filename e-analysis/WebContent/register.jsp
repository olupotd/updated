<%@page session="true" language="java" autoFlush="true"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link href="css/960.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/reset.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/text.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/login.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
	<div class="container_16">
		<div class="grid_6 prefix_5 suffix_5">
			<h1>User- Login</h1>
			<div id="login">
				<p class="tip">You just need to hit the button and you're in!</p>
				<p class="error">${status}</p>
				<form method="post" action="register">
					<p>
						<label><strong>Username</strong> <input type="text"
							name="username" class="inputText" /> </label>
					</p>
					<p>
						<label><strong>Full Names</strong> <input type="text"
							name="fullnames" class="inputText" /> </label>
					</p>
					<p>
						<label><strong>Email</strong> <input type="text"
							name="email" class="inputText" /> </label>
					</p>
					<p>
						<label><strong>Password</strong> <input type="password"
							name="password" class="inputText" /> </label>
					</p>
					<p>
						<input type="submit" value="Get Started">
					</p>
				</form>
			</div>
			<div id="forgot">
				<a href="register.jsp" class="forgotlink"><span>Register
						here</span></a>
			</div>
		</div>
	</div>
</body>
</html>

