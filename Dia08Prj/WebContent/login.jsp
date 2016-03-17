<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Iniciar Sesión</title>
</head>
<body>
	<form action="LoginService" method="POST">
		<label for="usuario">Usuario:</label>
		<input type="text" name="usuario" id="usuario" placeholder="Usuario">
		<label for="contrasena">Contraseña:</label>
		<input type="password" name="contrasena" id="contrasena" placeholder="Contraseña">
		<input type="submit" value="Ingresar">
	</form>
</body>
</html>