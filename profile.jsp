<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome ${user.name }
	<br/>
	<br/>
	${message}
	<form action="EditProfileController" method="post">
	UserName:<input type="hidden" name="username" value="${user.username }"><br/>
	Name:<input type="text" name="name" value="${user.name }"><br/>
	Age :<input type="number" name="age" value="${user.age }"><br/>
	Password:<input type="password" name="password" value="${user.password }"><br/>
	Salary :<input type="number" name="salary" value= "${user.salary }"><br/>
	<input type="submit" value="update"><br/>
	<a href="LogoutController">Logout</a>
	</form>
</body>
</html>