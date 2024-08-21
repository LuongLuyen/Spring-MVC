<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action='home' method="post">
		<label for="username">Name:</label> <input type="text" id="username"
			name="username" required><br> <br> <label
			for="password">Password:</label> <input type="password" id="password"
			name="password" required><br> <br> <input
			type="submit" value="Submit">
	</form>

	<!-- 	put, delete chi can chinh trong jsp controller PUT,DELETE binh thuong -->
	<!-- 	<form action="/updateUser" method="post">
		<input type="hidden" name="_method" value="PUT"> <label
			for="username">Username:</label> <input type="text" id="username"
			name="username"><br>
		<br> <label for="email">Email:</label> <input type="email"
			id="email" name="email"><br>
		<br> <input type="submit" value="Update">
	</form> -->

</body>
</html>