<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="mx.edu.ulsaoaxaca.sistema.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${param["error"]}</h1>
	<form action="main.jsp" method="POST">
		<label for="user">Usuario:</label>
		<input id="user" type="text" placeholder="Usuario" name="user">
		<label for="pass">Contrasena:</label>
		<input id="pass" type="password" placeholder="Contraseña" name="pass">
		<input type="submit" value="Login">
	 </form>
</body>
</html>