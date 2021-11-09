<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="formlogin.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form  action="/WebBook/login" method="post">
			<h2>Login WebBook</h2>
			<input type = "text" name = "user" placeholder="User">
			<input type = "password" name = "password" placeholder="Password">
			<button >Login</button>
			
			<div class="container signin">
    			<p style="padding-top: 32px ;background-color: white;">Already haven't an account? <a style="color: dodgerblue;" href="FormRegister.jsp">Register in</a>.</p>
 			</div>
		</form>
		
	</div>
	
</body>
</html>