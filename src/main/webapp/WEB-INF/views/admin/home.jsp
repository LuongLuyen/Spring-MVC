<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Admin</title>

</head>

<body>
	<h1>Admin</h1>
	<p>Trạng thái Login: ${checkLogin}</p>
	<div>
		<div>
			<a href="home">Đến trang Web</a>
		</div>

		<c:forEach var="item" items="${model}">
		    <h1>ID: ${item.id}</h1>
			<p>TK: ${item.userName}</p>
			<p>MK: ${item.password}</p>
			<p>FullName: ${item.fullName}</p>
		</c:forEach>
	</div>
	<div>
		<a href="login">Logout</a>
	</div>
</body>

</html>